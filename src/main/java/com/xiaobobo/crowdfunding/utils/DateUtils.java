package com.xiaobobo.crowdfunding.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * @author xiaobobo
 * @project espcp
 * @description (日期工具类)
 * @date 2018年1月26日
 */
public class DateUtils {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    private static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMdd");

    /**
     * 获取当前日期yyyy-MM-dd
     *
     * @return
     */
    public static String getCurrentDate() {
        return sdf2.format(new Date());
    }

    /**
     * 获取当前日期yyyyMMdd
     */
    public static String getTodayDate() {
        return sdf3.format(new Date());
    }

    /**
     * 获取下一天
     *
     * @return
     */
    public static String getNextDate() {
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, 1);
        return sdf2.format(ca.getTime());
    }

    /**
     * 获取下一年的今天
     *
     * @return
     */
    public static String getNextYear() {
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.YEAR, 1);
        return sdf2.format(ca.getTime());
    }

    /**
     * 获取当前时间yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getCurrentTime() {
        return sdf.format(new Date());
    }

    /**
     * 获取当前时间yyyy-MM-dd HH:mm:ss.SSS
     *
     * @return
     */
    public static String getCurrentTimeCS() {
        return sdf1.format(new Date());
    }

    /**
     * 获取当天的开始时间
     *
     * @return yyyy-MM-dd 格式
     */
    public static Date getDayBegin() {
//    	Date date = new Date();
//    	return getDayStartTime(date);

        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取当天的结束时间
     *
     * @return yyyy-MM-dd 格式
     */
    public static Date getDayEnd() {
//    	Date date = new Date();
//    	return getDayEndTime(date);

        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    /**
     * 获取昨天的开始时间
     *
     * @return yyyy-MM-dd 格式
     */
    public static Date getYesterdayBegin() {
//    	Date date = new Date();
//    	Date yesterday = new Date(date.getTime() - 86400000L);
//    	return getDayStartTime(yesterday);

        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayBegin());
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }

    /**
     * 获取距离今天前或后几天的日期
     *
     * @return yyyy-MM-dd 格式
     */
    public static Date getDayStartWithToday(int i) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayBegin());
        cal.add(Calendar.DAY_OF_MONTH, i);
        return cal.getTime();
    }

    /**
     * 获取昨天的结束时间
     *
     * @return yyyy-MM-dd 格式
     */
    public static Date getYesterdayEnd() {
//    	Date date = new Date();
//    	Date yesterday = new Date(date.getTime() - 86400000L);
//    	return getDayEndTime(yesterday);
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayEnd());
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }


    /**
     * 获取本周的开始时间
     *
     * @return yyyy-MM-dd 格式
     */
    public static Date getBeginDayOfWeek() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayofweek);
        return getDayStartTime(cal.getTime());
    }

    /**
     * 获取本周的结束时间
     *
     * @return yyyy-MM-dd 格式
     */
    public static Date getEndDayOfWeek() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getBeginDayOfWeek());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        Date weekEndSta = cal.getTime();
        return getDayEndTime(weekEndSta);
    }

    /**
     * 获取本月的开始时间
     *
     * @return yyyy-MM-dd 格式
     */
    public static Date getBeginDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth() - 1, 1);
        return getDayStartTime(calendar.getTime());
    }

    /**
     * 获取本月的结束时间
     *
     * @return yyyy-MM-dd 格式
     */
    public static Date getEndDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth() - 1, 1);
        int day = calendar.getActualMaximum(5);
        calendar.set(getNowYear(), getNowMonth() - 1, day);
        return getDayEndTime(calendar.getTime());
    }

    /**
     * 获取上月的开始时间
     *
     * @return
     */
    public static Date getBeginDayOfLastMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(getNowYear(), getNowMonth() - 2, 1);
        return getDayStartTime(calendar.getTime());
    }

    /**
     * 获取某个日期的开始时间
     *
     * @param d
     * @return yyyy-MM-dd 格式
     */
    public static Timestamp getDayStartTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d) calendar.setTime(d);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * 获取某个日期的结束时间
     *
     * @param d
     * @return yyyy-MM-dd 格式
     */
    public static Timestamp getDayEndTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d) calendar.setTime(d);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * 获取某年某月的第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getStartMonthDate(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        return calendar.getTime();
    }

    /**
     * 获取某年某月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getEndMonthDate(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        int day = calendar.getActualMaximum(5);
        calendar.set(year, month - 1, day);
        return calendar.getTime();
    }

    /**
     * 获取今年是哪一年
     *
     * @return
     */
    public static Integer getNowYear() {
        Date date = new Date();
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return Integer.valueOf(gc.get(1));
    }

    /**
     * 获取本月是哪一月
     *
     * @return
     */
    public static int getNowMonth() {
        Date date = new Date();
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return gc.get(2) + 1;
    }

    /**
     * 获取最近 X 个月份
     *
     * @return
     */
    public static String[] getLastXMonths(int X) {
        String[] last12Months = new String[X];
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1); // 要先+1,才能把本月的算进去</span>
        for (int i = 0; i < X; i++) {
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1); // 逐次往前推1个月
            String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
            if (month.length() == 1) {
                month = "0" + month;// 格式化 例：2018-01
            }
            last12Months[X - 1 - i] = cal.get(Calendar.YEAR) + "-" + month;
        }
        return last12Months;
    }


    /**
     * 相差天数 yyyy-MM-dd
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int calcDayOffset(String date1, String date2) {
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal1 = Calendar.getInstance();
        try {
            cal1.setTime(sdf2.parse(date1));
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(sdf2.parse(date2));
            int day1 = cal1.get(Calendar.DAY_OF_YEAR);
            int day2 = cal2.get(Calendar.DAY_OF_YEAR);

            int year1 = cal1.get(Calendar.YEAR);
            int year2 = cal2.get(Calendar.YEAR);
            if (year1 != year2) { // 同一年
                int timeDistance = 0;
                for (int i = year1; i < year2; i++) {
                    if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) { // 闰年
                        timeDistance += 366;
                    } else { // 不是闰年

                        timeDistance += 365;
                    }
                }
                return timeDistance + (day2 - day1);
            } else { // 不同年
                return day2 - day1;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 把日期转换为yyyy-MM-dd HH:mm:ss的格式
     *
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        return sdf.format(date);
    }

    public static long getMillisecondByDate(String dateStr) throws ParseException {
        if (CommonUtils.isEmpty(dateStr)) {
            return 0;
        }
        Date date = sdf2.parse(dateStr);
        long time = date.getTime();
        return time;
    }

}
