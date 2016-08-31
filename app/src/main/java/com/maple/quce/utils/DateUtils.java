package com.maple.quce.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author maple
 * @time 16/5/30 下午3:04
 */
public class DateUtils {

    /**
     * 日期按规定格式输出
     *
     * @param fmt 指定格式，如yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String date2Str(String fmt) {
        return date2Str(new Date(), fmt);
    }

    /**
     * 日期按规定格式输出
     *
     * @param date
     * @param fmt  指定格式，如yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String date2Str(Date date, String fmt) {
        if (date == null) {
            return "";
        }
        DateFormat dateFormat = new SimpleDateFormat(fmt);
        return dateFormat.format(date);
    }


    /**
     * 把字符串转为日期
     *
     * @param strDate
     * @param fmt
     * @return
     */
    public static Date str2Date(String strDate, String fmt) {
        try {
            DateFormat df = new SimpleDateFormat(fmt);
            return df.parse(strDate);
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 格式化时间
     *
     * @param date 秒
     * @return 00:23
     */
    public static String formatDate(long date) {
        date = date / 1000;// ms --> s
        return String.format("%1$02d%2$s%3$02d", date / 60, ":", date % 60);
    }
}
