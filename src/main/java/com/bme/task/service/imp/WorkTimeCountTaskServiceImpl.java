package com.bme.task.service.imp;

import com.bme.task.dao.mysql.TreatmentWorkTimeMapper;
import com.bme.task.dao.tidb.CountWorkTimeMapper;
import com.bme.task.service.WorkTimeCountTaskService;
import com.bme.task.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author yutyi
 * @date 2020/06/03
 */
@Service
public class WorkTimeCountTaskServiceImpl implements WorkTimeCountTaskService {

    private Logger logger = LoggerFactory.getLogger(WorkTimeCountTaskServiceImpl.class);

    @Autowired
    private CountWorkTimeMapper countWorkTimeMapper;

    @Autowired
    private TreatmentWorkTimeMapper treatmentWorkTimeMapper;

    @Override

    public boolean countWorkTime(long startTime, Long endTime) {

        HashMap<String, Object> paramMap = new HashMap<>(2);
        paramMap.put("startTime", startTime * 1000);
        paramMap.put("endTime", endTime * 1000);

        List<Map<String, Object>> list = new ArrayList<>();

        //统计除尘器工作时长
        List<Map<String, Object>> countDuster = countWorkTimeMapper.countDuster(paramMap);
        if (!CollectionUtils.isEmpty(countDuster)) {
            list.addAll(countDuster);
        }
        //统计纳膜工作时长
        List<Map<String, Object>> countNanofiltration = countWorkTimeMapper.countNanofiltration(paramMap);
        if (!CollectionUtils.isEmpty(countNanofiltration)) {
            list.addAll(countNanofiltration);
        }
        //统计雾炮/天雾工作时长
        List<Map<String, Object>> countWpTw = countWorkTimeMapper.countWpTw(paramMap);
        if (!CollectionUtils.isEmpty(countWpTw)) {
            list.addAll(countWpTw);
        }

        if (!CollectionUtils.isEmpty(list)) {
            String createTime = CommonUtil.dateFormat.format(new Date(endTime));
            for (Map<String, Object> map : list) {
                map.put("createTime", createTime);
            }
            Integer count = insert(list);
            if (count > 0) {
                logger.info("统计治理设备工作时长插入成功");
                return true;
            } else {
                logger.error("统计治理设备工作时长插入失败");
                return false;
            }
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer insert(List<Map<String,Object>> list) {
        Integer count = treatmentWorkTimeMapper.insert(list);
        return count;
    }
}
