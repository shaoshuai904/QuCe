package com.maple.quce.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author maple
 * @time 16/6/3 上午11:30
 */
public class Base64Utils {

    private Base64Utils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static String bitmapToBase64(Bitmap bitmap) {
        String result = null;
        ByteArrayOutputStream baos = null;
        try {
            if (bitmap != null) {
                baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                baos.flush();
                baos.close();
                result = Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.flush();
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static Bitmap base64ToBitmap(String base64Data) {
        byte[] bytes = Base64.decode(base64Data, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }


    public static String readStream(String path) {
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        return readStream(new File(path));
    }

    public static String readStream(File file) {
        String result = null;
        try {
            if (file.exists()) {
                InputStream inStream = new FileInputStream(file);
                byte[] buffer = new byte[1024];
                int len = -1;
                ByteArrayOutputStream outStream = new ByteArrayOutputStream();
                while ((len = inStream.read(buffer)) != -1) {
                    outStream.write(buffer, 0, len);
                }
                outStream.close();
                inStream.close();
                result = Base64.encodeToString(outStream.toByteArray(), Base64.DEFAULT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        FileUtils.writeString(new File(QuApp.rootPath + "wav.txt"), result);
//        L.e("liu", result);
        return result;
    }
}
