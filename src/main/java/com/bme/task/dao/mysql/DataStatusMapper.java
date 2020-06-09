package com.bme.task.dao.mysql;

import com.bme.task.vo.DeviceDataStatus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 数据状态
 *
 * @author yutyi
 * @date 2020/06/09
 */
@Mapper
public interface DataStatusMapper {

    /**
     * 设备列表
     * @param list
     * @return
     */
    List<DeviceDataStatus> selectDeviceStatusList(List<Long> list);

    /**
     * 录入设备数据状态
     * @param deviceDataStatuses
     * @return
     */
    Integer insert(List<DeviceDataStatus> deviceDataStatuses);

}
