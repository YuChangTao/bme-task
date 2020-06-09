package com.bme.task.controller;

import com.bme.task.common.bean.Page;
import com.bme.task.common.bean.QuartzTaskInformations;
import com.bme.task.service.quartz.QuartzService;
import com.bme.task.util.ResultEnum;
import com.bme.task.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName IndexController
 * @Description 首页跳转controller
 * @author yutyi
 */
@Controller
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private QuartzService quartzService;

    @RequestMapping("/success")
    @ResponseBody
    public String success() {
        return ResultUtil.success(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage());

    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listTasks(Model model, @RequestParam(value = "currentPage", required = false, defaultValue = "1") String currentPage,
                            @RequestParam(value = "taskNo", required = false) String taskNo) {
        try {
            List<QuartzTaskInformations> taskList = quartzService.getTaskList(taskNo, currentPage);
            int current = Integer.parseInt(currentPage);
            Page<QuartzTaskInformations> page = new Page(taskList, taskList.size(), current);
            model.addAttribute("taskList", taskList);
            model.addAttribute("size", taskList.size());
            model.addAttribute("currentPage", page.getCurrentPage());
            model.addAttribute("totalPage", page.getTotalPage());
            model.addAttribute("taskNo", taskNo);
        } catch (Exception e) {
            logger.error("首页跳转发生异常exceptions-->" + e.toString());
        }
        return "index";
    }
}
