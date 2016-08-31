package com.maple.quce.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * @author maple
 * @time 16/7/28 上午11:30
 */
public class FileUtils {

    public static String getFileSizeStr(File file) {
        return formatSize(getFileSize(file));
    }

    public static long getFileSize(File file) {
        long size = 0;
        if (file.exists()) {
            try {
                FileInputStream fis = new FileInputStream(file);
                size = fis.available();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return size;
    }

    public static String formatSize(long size) {
        DecimalFormat df = new DecimalFormat("####.00");
        if (size < 1024) {
            return size + "byte";
        } else if (size < 1024 * 1024) {
            float kbsize = size / 1024f;
            return df.format(kbsize) + "KB";
        } else if (size < 1024 * 1024 * 1024) {
            float mbsize = size / 1024f / 1024f;
            return df.format(mbsize) + "MB";
        } else if (size < 1024 * 1024 * 1024 * 1024) {
            float gbsize = size / 1024f / 1024f / 1024f;
            return df.format(gbsize) + "GB";
        } else {
            return "size: error";
        }
    }

    public static boolean writeString(File file, String str) {
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(str);
            fw.flush();
            fw.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
