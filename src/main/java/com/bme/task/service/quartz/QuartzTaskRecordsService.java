package com.bme.task.service.quartz;


import com.bme.task.common.bean.QuartzTaskRecords;

import java.util.List;

/**
 * 定时任务执行记录
 * @author yutyi
 */
public interface QuartzTaskRecordsService {

    /**
     * 初始化任务执行记录
     * @param quartzTaskRecords
     * @return
     */
    long addTaskRecords(QuartzTaskRecords quartzTaskRecords);

    /**
     * 更新任务执行状态
     * @param quartzTaskRecords
     * @return
     */
    Integer updateTaskRecords(QuartzTaskRecords quartzTaskRecords);

    /**
     * 通过任务编号查询任务执行列表
     * @param taskNo
     * @return
     */
    List<QuartzTaskRecords> listTaskRecordsByTaskNo(String taskNo);

}
