package com.bme.task.dao.tidb;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 事件变化
 *
 * @author yutyi
 * @date 2020/06/11
 */
@Mapper
public interface EventChangeMapper {

    /**
     * 插入事件
     * @param map
     * @return
     */
    Integer insert(Map<Object,Object> map);
}
