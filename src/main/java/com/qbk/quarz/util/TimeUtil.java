package com.qbk.quarz.util;

import org.springframework.scheduling.support.CronSequenceGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: quboka
 * @Date: 2018/10/22 11:22
 * @Description: cron 和 date 转换
 */
public class TimeUtil {

    private static final String CRON_DATE_FORMAT = "ss mm HH dd MM ? yyyy";

    /***
     *
     * @param date 时间
     * @return  cron类型的日期
     */
    public static String getCron(final Date  date){
        SimpleDateFormat sdf = new SimpleDateFormat(CRON_DATE_FORMAT);
        String formatTimeStr = "";
        if (date != null) {
            formatTimeStr = sdf.format(date);
        }
        return formatTimeStr;
    }

    /***
     *
     * @param cron Quartz cron的类型的日期
     * @return  Date日期
     */

    public static Date getDate(final String cron) {
        if(cron == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(CRON_DATE_FORMAT);
        Date date = null;
        try {
            date = sdf.parse(cron);
        } catch (Exception e) {
            // 此处缺少异常处理,自己根据需要添加
            return null;
        }
        return date;
    }

    public static void main(String[] args){
        Date now = new Date();
        System.out.println(TimeUtil.getCron(now));

        String cron = "*/10 * * * * ?";
        CronSequenceGenerator cronSequenceGenerator = new CronSequenceGenerator(cron);
        Date currentTime = new Date();
        System.out.println("currentTime: " + currentTime);
        // currentTime为计算下次时间点的开始时间
        Date nextTimePoint = cronSequenceGenerator.next(currentTime);
        System.out.println("nextTimePoint: " + nextTimePoint);
        Date nextNextTimePoint = cronSequenceGenerator.next(nextTimePoint);
        System.out.println("nextNextTimePoint: " + nextNextTimePoint);

    }
}
