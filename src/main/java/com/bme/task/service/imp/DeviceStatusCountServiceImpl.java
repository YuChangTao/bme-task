package com.bme.task.service.imp;

import com.bme.task.dao.mysql.DeviceStatusMapper;
import com.bme.task.dao.tidb.DataStatusCountMapper;
import com.bme.task.dao.tidb.DeviceStatusCountMapper;
import com.bme.task.service.DeviceStatusCountService;
import com.bme.task.util.CommonUtil;
import com.bme.task.vo.DeviceIndexStandard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * 统计工作时长
 *
 * @author yutyi
 * @date 2020/06/03
 */
@Service
public class DeviceStatusCountServiceImpl implements DeviceStatusCountService {

    private Logger logger = LoggerFactory.getLogger(WorkTimeCountTaskServiceImpl.class);

    @Autowired
    private DeviceStatusCountMapper deviceStatusCountMapper;

    @Autowired
    private DeviceStatusMapper deviceStatusMapper;

    @Autowired
    private DataStatusCountMapper dataIndexStandardMapper;

    @Override
    public boolean countMinuteDeviceStatus(long startTime, Long endTime, long intervalTime) {
        //查询所有客户及判断标准
        List<DeviceIndexStandard> deviceIndexStandards = dataIndexStandardMapper.selectDeviceIndexStandard();
        logger.info("客户指标：{}", deviceIndexStandards);
        List<Long> customerIdList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(deviceIndexStandards)) {
            ArrayList<Map<String, Object>> list = new ArrayList<>();
            for (DeviceIndexStandard standard : deviceIndexStandards) {
                customerIdList.add(standard.getCustomerId());
                standard.setStartTime(startTime * 1000);
                standard.setEndTime(endTime * 1000);
                //查询微站状态
                List<Map<String, Object>> countWzStatus = deviceStatusCountMapper.countWzStatus(standard);
                //查询TSP状态
                List<Map<String, Object>> countTspStatus = deviceStatusCountMapper.countTspStatus(standard);
                //查询VOC状态
                List<Map<String, Object>> vocStatus = deviceStatusCountMapper.countVocStatus(standard);
                if (!CollectionUtils.isEmpty(countWzStatus)) {
                    list.addAll(countWzStatus);
                }
                if (!CollectionUtils.isEmpty(countTspStatus)) {
                    list.addAll(countTspStatus);
                }
                if (!CollectionUtils.isEmpty(vocStatus)) {
                    list.addAll(vocStatus);
                }
            }

            //查询设备列表
            List<Map<String, Object>> deviceList = deviceStatusMapper.selectDeviceList(customerIdList);
            //查询在线设备列表
            Map<String, Object> param = new HashMap<>(2);
            param.put("startTime", startTime * 1000);
            param.put("endTime", endTime * 1000);
            List<Long> onlineList = deviceStatusCountMapper.selectOnline(param);

            List<Map<String, Object>> insertList = new ArrayList<>();

            //离线设备
            for (Map<String, Object> device : deviceList) {
                if (!onlineList.contains(Long.parseLong(device.get("deviceId").toString()))) {
                    device.put("state", 0);
                    device.put("createTime", endTime);
                    device.put("countDimension", intervalTime);
                    insertList.add(device);
                }
            }
            if (!CollectionUtils.isEmpty(list)) {
                for (Map<String, Object> map : list) {
                    map.put("createTime", endTime);
                    map.put("countDimension", intervalTime);
                }
                insertList.addAll(list);
            }
            Integer count = insert(insertList);
            if (count > 0) {
                logger.info("统计监控设备工作状态插入成功");
                return true;
            } else {
                logger.error("统计监控设备工作状态插入失败");
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean countHourDeviceStatus(long startTime, Long endTime) {
        Map<String, Object> param = new HashMap<>(2);
        param.put("startTime", startTime);
        param.put("endTime", endTime);
        List<Map<String, Object>> countHourStatus = deviceStatusCountMapper.countHourStatus(param);
        for (Map<String, Object> hourStatus : countHourStatus) {
            hourStatus.put("createTime", CommonUtil.dateFormat.format(new Date(endTime)));
        }
        Integer count = insertStatus(countHourStatus);
        return count > 0 ? true : false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer insert(List<Map<String, Object>> list) {
        Integer count = deviceStatusCountMapper.insert(list);
        return count;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer insertStatus(List<Map<String, Object>> list) {
        Integer count = deviceStatusMapper.insert(list);
        return count;
    }
}
