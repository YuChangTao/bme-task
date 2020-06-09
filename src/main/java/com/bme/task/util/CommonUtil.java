package com.bme.task.util;

import org.apache.commons.lang3.time.DateUtils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName CommonUtil
 * @Description 通用工具类
 * @author yutyi
 */
public class CommonUtil {

    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat hourFormat = new SimpleDateFormat("yyyy-MM-dd HH");
    /**
     * 获取具体的异常信息
     *
     * @param ex
     * @return
     */
    public static String getExceptionDetail(Exception ex) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        try {
            ex.printStackTrace(pw);
            return sw.toString();
        } finally {
            pw.close();
        }
    }

    /**
     * 转换成日期格式
     *
     * @param str
     * @return
     */
    public static Date toDate(String str) {
        String[] patterns = new String[] { "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM-dd HH","yyyy-MM-dd", "HH:mm:ss", "HH:mm", "yyyy/M/d H:m:s", "HH:mm", "yyyy/M/d H:m", "yyyy/M/d",
                "H:m:s", "H:m", "yyyy-MM-dd HH:mm:ss.SSS" };
        try {
            return DateUtils.parseDate(str,patterns);
        } catch (Exception ex) {
            return null;
        }
    }
}
