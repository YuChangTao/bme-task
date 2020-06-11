package com.bme.task.controller;

import com.bme.task.service.DeviceStatusCountService;
import com.bme.task.util.CommonUtil;
import com.bme.task.util.ResultUtil;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Map;

/**
 * 设备状态统计任务
 *
 * @author yutyi
 * @date 2020/06/04
 */
@RestController
@RequestMapping("deviceStatus")
public class DeviceStatusCountTaskController {

    private Logger logger = LoggerFactory.getLogger(DeviceStatusCountTaskController.class);

    @Autowired
    private DeviceStatusCountService deviceStatusCountService;

    /**
     * 废弃
     * @param requestParam
     * @return
     */
    @RequestMapping("countMinute")
    public String countMinuteState (@RequestBody(required = false) String requestParam) {
        if (StringUtils.isEmpty(requestParam)) {
            logger.warn("统计监控设备状态执行参数requestParam为空");
            return null;
        }
        boolean result = false;
        try {
            Gson gson = new Gson();
            Map<String, Object> map = gson.fromJson(requestParam, Map.class);
            Object endTimeStr = map.get("endTimeStr");
            Object intervalTime = map.get("intervalTime");
            Long endTime;
            if (endTimeStr != null && intervalTime != null) {

                endTime = CommonUtil.dateFormat.parse((String) endTimeStr).getTime();
                long interval = (long)Double.parseDouble(intervalTime.toString());
                long startTime = endTime - interval;
                result = deviceStatusCountService.countMinuteDeviceStatus(startTime, endTime,interval);
            } else if (intervalTime != null) {
                endTime = System.currentTimeMillis();
                long interval = (long)Double.parseDouble(intervalTime.toString());
                long startTime = endTime - interval;
                result = deviceStatusCountService.countMinuteDeviceStatus(startTime, endTime,interval);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            logger.warn("统计监控设备状态发生异常：{}",e.getMessage());
            return null;
        }
        return result? ResultUtil.success(): null;

    }

    /**
     * 废弃
     * @param requestParam
     * @return
     */
    @RequestMapping("countHour")
    public String countHourState (@RequestBody(required = false) String requestParam) {
        if (StringUtils.isEmpty(requestParam)) {
            logger.warn("统计监控设备小时状态执行参数requestParam为空");
            return null;
        }
        boolean result = false;
        try {
            Gson gson = new Gson();
            Map<String, Object> map = gson.fromJson(requestParam, Map.class);
            Object endTimeStr = map.get("endTimeStr");
            Object intervalTime = map.get("intervalTime");
            Long endTime;
            if (endTimeStr != null && intervalTime != null) {

                endTime = CommonUtil.dateFormat.parse((String) endTimeStr).getTime();
                long interval = (long)Double.parseDouble(intervalTime.toString());
                long startTime = endTime - interval;
                result = deviceStatusCountService.countHourDeviceStatus(startTime, endTime);
            } else if (intervalTime != null) {
                endTime = System.currentTimeMillis();
                long interval = (long)Double.parseDouble(intervalTime.toString());
                long startTime = endTime - interval;
                result = deviceStatusCountService.countHourDeviceStatus(startTime, endTime);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            logger.warn("统计监控设备小时状态发生异常：{}",e.getMessage());
            return null;
        }
        return result? ResultUtil.success(): null;

    }
}
