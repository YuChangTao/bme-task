package com.bme.task.service.quartz;



import com.bme.task.common.bean.QuartzTaskInformations;

import java.util.List;

public interface QuartzTaskInformationsService {
    String insert(QuartzTaskInformations quartzTaskInformations);

    List<QuartzTaskInformations> selectList(String taskNo, String currentPage);

    QuartzTaskInformations getTaskById(String id);

    /**
     * 更新任务
     * @param quartzTaskInformations
     * @return
     */
    String updateTask(QuartzTaskInformations quartzTaskInformations);

    QuartzTaskInformations getTaskByTaskNo(String taskNo);

    Integer updateStatusById(QuartzTaskInformations quartzTaskInformations);

    List<QuartzTaskInformations> getUnnfrozenTasks(String status);

    Integer updateModifyTimeById(QuartzTaskInformations quartzTaskInformations);
}
