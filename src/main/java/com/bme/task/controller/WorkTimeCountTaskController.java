package com.bme.task.controller;

import com.bme.task.service.WorkTimeCountTaskService;
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
 * 工作时长统计任务
 *
 * @author yutyi
 * @date 2020/06/03
 */
@RestController
@RequestMapping("workTime")
public class WorkTimeCountTaskController {

    private Logger logger = LoggerFactory.getLogger(WorkTimeCountTaskController.class);

    @Autowired
    private WorkTimeCountTaskService workTimeCountTaskService;


    /**
     * @param requestParam 请求参数
     *                     endTimeStr   统计结束时间
     *                     intervalTime 时间间隔
     * @return
     */
    @RequestMapping("count")
    public String countWorkTime(@RequestBody(required = false) String requestParam) {
        if (StringUtils.isEmpty(requestParam)) {
            logger.warn("统计治理设备工作时长执行参数requestParam为空");
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
                long startTime = endTime - (long)Double.parseDouble(intervalTime.toString());
                result = workTimeCountTaskService.countWorkTime(startTime, endTime);
            } else if (intervalTime != null) {
                endTime = System.currentTimeMillis();
                long startTime = endTime - (long)Double.parseDouble(intervalTime.toString());
                result = workTimeCountTaskService.countWorkTime(startTime, endTime);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            logger.warn("统计治理设备工作时长发生异常：{}",e.getMessage());
            return null;
        }
        return result? ResultUtil.success(): null;
    }

}
