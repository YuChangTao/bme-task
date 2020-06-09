package com.bme.task.service.imp;

import com.bme.task.dao.mysql.DataStatusMapper;
import com.bme.task.dao.tidb.DataStatusCountMapper;
import com.bme.task.service.DataStatusCountService;
import com.bme.task.vo.DeviceDataStatus;
import com.bme.task.vo.DeviceIndexStandard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 数据状态统计
 *
 * @author yutyi
 */
@Service
public class DataStatusCountServiceImpl implements DataStatusCountService {

    private Logger logger = LoggerFactory.getLogger(DataStatusCountServiceImpl.class);
    @Autowired
    private DataStatusCountMapper dataStatusCountMapper;

    @Autowired
    private DataStatusMapper dataStatusMapper;

    @Override
    public boolean countDataStatus(Long startTime, Long endTime) {
        //查询所有客户及判断标准
        List<DeviceIndexStandard> deviceIndexStandards = dataStatusCountMapper.selectDeviceIndexStandard();
        logger.info("客户指标：{}", deviceIndexStandards);
        List<Long> customerIdList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(deviceIndexStandards)) {
            ArrayList<DeviceDataStatus> list = new ArrayList<>();
            for (DeviceIndexStandard standard : deviceIndexStandards) {
                customerIdList.add(standard.getCustomerId());
                standard.setStartTime(startTime * 1000);
                standard.setEndTime(endTime * 1000);
                //查询微站状态
                List<DeviceDataStatus> countWzStatus = dataStatusCountMapper.countWzExceptionAndExceed(standard);
                //查询TSP状态
                List<DeviceDataStatus> countTspStatus = dataStatusCountMapper.countTspExceptionAndExceed(standard);
                //查询VOC状态
                List<DeviceDataStatus> vocStatus = dataStatusCountMapper.countVocExceptionAndExceed(standard);
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
            List<DeviceDataStatus> deviceList = dataStatusMapper.selectDeviceStatusList(customerIdList);
            Date date = new Date(endTime);
            for (DeviceDataStatus dataStatus : deviceList) {
                for (DeviceDataStatus deviceDataStatus : list) {
                    dataStatus.setCreateTime(date);
                    if (dataStatus.getDeviceId() - deviceDataStatus.getDeviceId() == 0) {
                        dataStatus.setTotal(deviceDataStatus.getTotal());
                        dataStatus.setExCount(deviceDataStatus.getExCount());
                        dataStatus.setExceedCount(deviceDataStatus.getExceedCount());
                        dataStatus.setReportRate(deviceDataStatus.getReportRate());
                    }
                }
            }
            Integer count = insert(deviceList);
            return count > 0 ? true : false;
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer insert(List<DeviceDataStatus> deviceDataStatuses) {
        Integer count = dataStatusMapper.insert(deviceDataStatuses);
        return count;
    }
}
