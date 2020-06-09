package com.bme.task.service;

import java.util.List;
import java.util.Map;

/**
 * @author yutyi
 * @date 2020/06/03
 */
public interface WorkTimeCountTaskService {


    /**
     * 统计工作时长
     * @param startTime
     * @param endTime
     */
    boolean countWorkTime(long startTime, Long endTime);

    /**
     * 插入
     * @param list
     * @return
     */
    Integer insert(List<Map<String,Object>> list);
}
