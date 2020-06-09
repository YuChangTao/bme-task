package com.bme.task.service;

import com.bme.task.vo.DeviceDataStatus;

import java.util.List;

/**
 * @author yutyi
 */
public interface DataStatusCountService {

    /**
     * 数据状态统计
     * @param startTime
     * @param endTime
     * @return
     */
    boolean countDataStatus(Long startTime,Long endTime);

    /**
     * 录入设备数据状态
     * @param deviceDataStatuses
     * @return
     */
    Integer insert(List<DeviceDataStatus> deviceDataStatuses);
}
