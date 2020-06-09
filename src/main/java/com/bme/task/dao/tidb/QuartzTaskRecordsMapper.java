package com.bme.task.dao.tidb;


import com.bme.task.common.bean.QuartzTaskRecords;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 定时任务执行记录
 * @author yutyi
 */
@Mapper
public interface QuartzTaskRecordsMapper {
    int deleteByPrimaryKey(Long id);

    long insert(QuartzTaskRecords record);

    int insertSelective(QuartzTaskRecords record);

    QuartzTaskRecords selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QuartzTaskRecords record);

    int updateByPrimaryKey(QuartzTaskRecords record);

    List<QuartzTaskRecords> getTaskRecordsByTaskNo(String taskNo);
}
