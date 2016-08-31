package com.maple.quce.utils;


import android.text.TextUtils;

/**
 * @author maple
 * @time 16/4/14 下午5:37
 */
public class StringUtils {
    public StringUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static boolean checkEmail(String email) {
        // TODO 应该用正则表达式检验邮箱是否合格
        if (!TextUtils.isEmpty(email) && email.length() >= 4) {
            return true;
        }
        return false;
    }

    public static boolean checkPwd(String password) {
        if (!TextUtils.isEmpty(password) && password.length() >= 4) {
            return true;
        }
        return false;
    }

    // 获取一个字符串开头的数字
    public static String gerFirstNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return str.substring(0, i);
            }
        }
        return str;
    }

}
