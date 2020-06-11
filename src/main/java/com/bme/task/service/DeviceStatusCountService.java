package com.bme.task.service;

import com.bme.task.vo.DeviceStatus;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 统计工作时长（废弃）
 *
 * @author yutyi
 * @date 2020/06/03
 */
public interface DeviceStatusCountService {

    /**
     * 统计设备工作状态
     *
     * @param startTime
     * @param endTime
     * @return
     */
    boolean countDeviceStatus(long startTime, long endTime, long interval);


    Integer insert(List<DeviceStatus> deviceStatusList);

    Integer update(List<Long> offList, Date createTime, long interval);
}
