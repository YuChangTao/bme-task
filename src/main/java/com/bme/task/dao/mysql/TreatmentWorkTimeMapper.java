package com.bme.task.dao.mysql;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 治理设备运行时长
 *
 * @author yutyi
 * @date 2020/06/03
 */
@Mapper
public interface TreatmentWorkTimeMapper {

    /**
     * 批处理插入设备运行时长
     * @param list
     * @return
     */
    Integer insert(List<Map<String,Object>> list);

}
