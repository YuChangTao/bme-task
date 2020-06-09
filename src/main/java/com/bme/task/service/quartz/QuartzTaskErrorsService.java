package com.bme.task.service.quartz;


import com.bme.task.common.bean.QuartzTaskErrors;

/**
 * 定时任务执行错误记录
 * @author yutyi
 */
public interface QuartzTaskErrorsService {

    /**
     * 添加定时任务执行错误记录
     * @param quartzTaskErrors
     * @return
     */
    Integer addTaskErrorRecord(QuartzTaskErrors quartzTaskErrors);

    /**
     * 通过执行记录id查询执行错误详情
     * @param recordId
     * @return
     */
    QuartzTaskErrors detailTaskErrors(String recordId);
}
