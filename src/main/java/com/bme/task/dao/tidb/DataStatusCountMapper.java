package com.bme.task.dao.tidb;

import com.bme.task.vo.DeviceDataStatus;
import com.bme.task.vo.DeviceIndexStandard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 数据状态判断标准
 *
 * @author yutyi
 * @date 2020/06/09
 */
@Mapper
public interface DataStatusCountMapper {

    /**
     * 查询指标
     * @return
     */
    List<DeviceIndexStandard> selectDeviceIndexStandard();

    /**
     * 统计微站异常和超标次数
     * @param standard
     * @return
     */
    List<DeviceDataStatus> countWzExceptionAndExceed(DeviceIndexStandard standard);

    /**
     * 统计TSP异常和超标次数
     * @param standard
     * @return
     */
    List<DeviceDataStatus> countTspExceptionAndExceed(DeviceIndexStandard standard);

    /**
     * 统计Voc异常和超标次数
     * @param standard
     * @return
     */
    List<DeviceDataStatus> countVocExceptionAndExceed(DeviceIndexStandard standard);
}
