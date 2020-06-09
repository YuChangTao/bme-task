package com.bme.task.dao.tidb;


import com.bme.task.common.bean.QuartzTaskInformations;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 定时任务执行任务列表
 * @author yutyi
 */
@Mapper
public interface QuartzTaskInformationsMapper {
    /**
     * 删除指定任务
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入指定任务，所有字段
     * @param record
     * @return
     */
    int insert(QuartzTaskInformations record);

    /**
     * 插入指定任务，选择性字段
     * @param record
     * @return
     */
    int insertSelective(QuartzTaskInformations record);

    /**
     * 根据任务id查询任务详情
     * @param id
     * @return
     */
    QuartzTaskInformations selectByPrimaryKey(Long id);

    /**
     * 根据任务id选择性更新字段
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(QuartzTaskInformations record);

    /**
     * 根据任务id更新所有字段
     * @param record
     * @return
     */
    int updateByPrimaryKey(QuartzTaskInformations record);

    /**
     * 查询列表
     * @param map
     * @return
     */
    List<QuartzTaskInformations> selectList(Map<String, Object> map);

    /**
     * 通过任务编码查询任务数量
     * @param taskNo
     * @return
     */
    Integer selectByTaskNo(String taskNo);

    /**
     * 通过任务编码获取任务
     * @param taskNo
     * @return
     */
    QuartzTaskInformations getTaskByTaskNo(String taskNo);

    /**
     * 获取未冻结任务
     * @param status
     * @return
     */
    List<QuartzTaskInformations> getUnfrozenTasks(String status);
}
