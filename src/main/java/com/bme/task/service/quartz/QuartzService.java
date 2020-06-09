package com.bme.task.service.quartz;


import com.bme.task.common.bean.QuartzTaskErrors;
import com.bme.task.common.bean.QuartzTaskInformations;
import com.bme.task.common.bean.QuartzTaskRecords;
import com.bme.task.vo.QuartzTaskRecordsVo;
import org.quartz.SchedulerException;

import java.util.List;

public interface QuartzService {
    String addTask(QuartzTaskInformations quartzTaskInformations);

    List<QuartzTaskInformations> getTaskList(String taskNo, String currentPage);

    QuartzTaskInformations getTaskById(String id);

    String updateTask(QuartzTaskInformations quartzTaskInformations);

    String startJob(String taskNo) throws SchedulerException;

    void initLoadOnlineTasks();

    void sendMessage(String message);

    /**
     * 添加任务执行记录
     * @param taskNo
     * @return
     */
    QuartzTaskRecords addTaskRecords(String taskNo);

    /**
     * 更新任务执行情况
     * @param count
     * @param id
     * @return
     */
    Integer updateRecordById(Integer count, Long id);

    Integer updateModifyTimeById(QuartzTaskInformations quartzTaskInformations);

    Integer addTaskErrorRecord(String id, String errorKey, String errorValue);

    List<QuartzTaskRecordsVo> taskRecords(String taskNo);

    String runTaskRightNow(String taskNo);

    QuartzTaskErrors detailTaskErrors(String recordId);
}
