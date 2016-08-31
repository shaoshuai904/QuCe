package com.maple.quce.utils;


import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Keyboard
 *
 * @author maple
 * @time 16/4/14 下午5:37
 */
public class KeyboardUtils {
    public KeyboardUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }


    /**
     * 打开软键盘
     *
     * @param view
     * @param mContext
     */
    public static void openKeyboard(View view, Context mContext) {
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, InputMethodManager.RESULT_SHOWN);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }


    /**
     * 关闭软键盘
     *
     * @param view
     * @param mContext
     */
    public static void closeKeyboard(View view, Context mContext) {
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


}
