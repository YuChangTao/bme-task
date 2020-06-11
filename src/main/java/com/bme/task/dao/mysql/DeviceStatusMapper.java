package com.bme.task.dao.mysql;

import com.bme.task.vo.DeviceStatus;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
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
     *
     * @return
     */
    List<DeviceStatus> selectDeviceList();

    /**
     * 是否已创建
     *
     * @param createTime
     * @return
     */
    Integer selectCount(Date createTime);

    /**
     * 插入状态
     *
     * @param list
     * @return
     */
    Integer insert(List<DeviceStatus> list);

    /**
     * 更新设备状态
     *
     * @param offList
     * @param createTime
     * @param interval
     * @return
     */
    Integer update(List<Long> offList, Date createTime, long interval);
}
