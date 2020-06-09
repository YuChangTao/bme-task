package com.bme.task.dao.tidb;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 统计工作时长
 *
 * @author yutyi
 * @date 2020/06/03
 */
@Mapper
public interface CountWorkTimeMapper {


    List<Map<String,Object>> countNanofiltration(Map<String,Object> map);

    List<Map<String,Object>> countWpTw(Map<String,Object> map);

    List<Map<String,Object>> countDuster(Map<String,Object> map);
}
