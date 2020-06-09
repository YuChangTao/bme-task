package com.bme.task.dao.mysql;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 设备状态
 *
 * @author yutyi
 * @date 2020/06/05
 */
@Mapper
public interface DeviceStatusMapper {

    /**
     * 查询设备列表
     * @param list
     * @return
     */
    List<Map<String,Object>> selectDeviceList(List<Long> list);

    /**
     * 插入状态
     * @param list
     * @return
     */
    Integer insert(List<Map<String,Object>> list);

}
