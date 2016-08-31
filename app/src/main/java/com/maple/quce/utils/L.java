package com.maple.quce.utils;


import android.util.Log;


/**
 * @author maple
 * @time 16/6/3 上午9:59
 */
public class L {

    public static boolean isShow = true;

    private L() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

//    　1、Log.v 的输出为黑色，输出 >= VERBOSE 日志级别的信息.
//    　2、Log.d 的输出是蓝色，输出 >= DEBUG 日志级别的信息.
//    　3、Log.i 的输出为绿色，输出 >= INFO 日志级别的信息.
//    　4、Log.w 的输出为橙色, 输出 >= WARN 日志级别的信息.
//    　5、Log.e 的输出为红色，仅输出 ERROR 日志级别的信息.

    public static void e(String message) {
        e("TAG", message);
    }

    public static void e(String tag, String message) {
        if (isShow)
            Log.e("-[" + tag + "]-", message);
    }

    public static void w(String message) {
        w("TAG", message);
    }

    public static void w(String tag, String message) {
        if (isShow)
            Log.w("-[" + tag + "]-", message);
    }

    public static void i(String message) {
        i("TAG", message);
    }

    public static void i(String tag, String message) {
        if (isShow)
            Log.i("-[" + tag + "]-", message);
    }

    public static void d(String message) {
        d("TAG", message);
    }

    public static void d(String tag, String message) {
        if (isShow)
            Log.d("-[" + tag + "]-", message);
    }

}