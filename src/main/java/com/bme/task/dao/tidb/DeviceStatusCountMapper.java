package com.bme.task.dao.tidb;

import com.bme.task.vo.DeviceIndexStandard;
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
public interface DeviceStatusCountMapper {


    /**
     * 统计微站工作状态
     * @param standard
     * @return
     */
    List<Map<String,Object>> countWzStatus(DeviceIndexStandard standard);

    /**
     * 统计TSP工作状态
     * @param standard
     * @return
     */
    List<Map<String,Object>> countTspStatus(DeviceIndexStandard standard);

    /**
     * 统计VOC工作状态
     * @param standard
     * @return
     */
    List<Map<String,Object>> countVocStatus(DeviceIndexStandard standard);

    /**
     * 插入设备工作状态
     * @param list
     * @return
     */
    Integer insert(List<Map<String,Object>> list);

    /**
     * 查询在线设备列表
     * @param map
     * @return
     */
    List<Long> selectOnline(Map<String,Object> map);

    /**
     * 统计小时设备状态
     * @param map
     * @return
     */
    List<Map<String,Object>> countHourStatus(Map<String,Object> map);
}
