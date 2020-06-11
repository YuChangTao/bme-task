package com.bme.task.service.imp;

import com.bme.task.common.RedisClientTemplate;
import com.bme.task.dao.mysql.DeviceStatusMapper;
import com.bme.task.service.DeviceStatusCountService;
import com.bme.task.util.CommonUtil;
import com.bme.task.vo.DeviceStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 统计工作时长
 *
 * @author yutyi
 * @date 2020/06/03
 */
@Service
public class DeviceStatusCountServiceImpl implements DeviceStatusCountService {

    private Logger logger = LoggerFactory.getLogger(WorkTimeCountTaskServiceImpl.class);

    @Autowired
    private DeviceStatusMapper deviceStatusMapper;

    @Autowired
    private RedisClientTemplate redisClientTemplate;

    @Override
    public boolean countDeviceStatus(long startTime, long endTime, long interval) {

        List<DeviceStatus> list = deviceStatusMapper.selectDeviceList();
        Set<String> keys = redisClientTemplate.keys("upDown:status:*");

        //数据是否已存在
        Date date = CommonUtil.toDate(CommonUtil.hourFormat.format(new Date(endTime)));
        Integer count = deviceStatusMapper.selectCount(date);

        List<Long> offList = new ArrayList<>();
        for (DeviceStatus device : list) {
            if (!CollectionUtils.isEmpty(keys) && keys.contains("upDown:status:" + device.getDeviceNo())) {
                device.setStatus(1);
            } else {
                device.setOutlineTime(interval);
                offList.add(device.getDeviceId());
            }
            device.setCreateTime(date);
        }
        int result;
        if (count > 0) {
            if (offList.size() > 0) {
                result = update(offList, date, interval);
            } else {
                result = 1;
            }
        } else {
            result = insert(list);
        }
        return result > 0 ? true : false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer insert(List<DeviceStatus> deviceStatusList) {
        return deviceStatusMapper.insert(deviceStatusList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer update(List<Long> offList, Date createTime, long interval) {
        return deviceStatusMapper.update(offList, createTime, interval);
    }
}
