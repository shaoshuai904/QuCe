package com.maple.quce;

import android.app.Application;
import android.os.Environment;

import com.maple.quce.utils.L;

import java.io.File;

public class QuApp extends Application {
    private static QuApp app;

    public static String rootPath = "/QuCe/";
    public static String errorPath = "/QuCe/error.txt";

    @Override
    public void onCreate() {
        app = this;
        super.onCreate();

        initPath();

    }

    private void initPath() {
        String ROOT = "";// /storage/emulated/0
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            ROOT = Environment.getExternalStorageDirectory().getPath();
            L.e("app", "系统方法：" + ROOT);
            //  ROOT = StorageUtils.getSdcardPath(this);
        }
        rootPath = ROOT + rootPath;
        errorPath = ROOT + errorPath;

        File lrcFile = new File(rootPath);
        if (!lrcFile.exists()) {
            lrcFile.mkdirs();
        }
    }

    public static QuApp app() {
        return app;
    }

}
