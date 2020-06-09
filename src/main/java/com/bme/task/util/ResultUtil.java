package com.bme.task.util;


import com.google.gson.Gson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName ResultUtil
 * @Description TODO
 * @author yutyi
 */
public class ResultUtil<T> {

    public static String success() {
        Result result = new Result(ResultEnum.SUCCESS);
        return new Gson().toJson(result);
    }

    public static String success(Object obj) {
        Result result = new Result(ResultEnum.SUCCESS, obj);
        return new Gson().toJson(result);
    }

    public static String fail() {
        Result result = new Result(ResultEnum.FAIL);
        return new Gson().toJson(result);
    }

    public static String success(Integer code, String message) {
        Result result = new Result(code, message);
        return new Gson().toJson(result);
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        /*System.out.println(format.parse("2020-06-09 09:00:00").getTime());
        System.out.println(format.parse("2020-06-09 10:00:00").getTime());

        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis()-60*1000);
        System.out.println(new Date(1591581600000L));
        System.out.println(new Date(1591585800000L));

        System.out.println(new Date(1591587000000L));
        System.out.println(new Date(1591587600000L));
        System.out.println(new Date(1591588200000L));*/
        String format1 = CommonUtil.hourFormat.format(new Date(System.currentTimeMillis()));
        System.out.println(CommonUtil.toDate(format1).getTime());
        System.out.println(new Date(CommonUtil.toDate(format1).getTime()));
    }


}
