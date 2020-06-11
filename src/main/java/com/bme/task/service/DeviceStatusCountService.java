package com.bme.task.service;

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
     * 统计设备分钟工作状态
     * @param startTime
     * @param endTime
     * @param intervalTime
     * @return
     */
    boolean countMinuteDeviceStatus(long startTime, Long endTime,long intervalTime);


    /**
     * 统计设备小时工作状态
     * @param startTime
     * @param endTime
     * @return
     */
    boolean countHourDeviceStatus(long startTime, Long endTime);

    /**
     * 插入设备工作状态
     * @param list
     * @return
     */
    Integer insert(List<Map<String, Object>> list);

    Integer insertStatus(List<Map<String, Object>> list);
}
