package com.maple.quce.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.annotation.NonNull;

import java.io.File;
import java.util.List;

/**
 * Package工具类
 */
public class PackageUtil {

    private PackageUtil() {
    }


    /**
     * 检查是否安装过某个应用
     */
    @SuppressWarnings("WrongConstant")
    public static boolean checkApkExist(
            @NonNull Context context, @NonNull String packageName) {
        try {
            ApplicationInfo info = context.getPackageManager()
                    .getApplicationInfo(packageName, PackageManager.GET_UNINSTALLED_PACKAGES);
            return info != null;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 根据包名打开应用
     */
    public static boolean openApp(@NonNull Context context, @NonNull String packageName) {
        PackageManager pm = context.getPackageManager();
        PackageInfo pi = null;
        try {
            pi = pm.getPackageInfo(packageName, 0);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        if (pi == null) {
            return false;
        }

        Intent resolveIntent = new Intent(Intent.ACTION_MAIN, null);
        resolveIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        resolveIntent.setPackage(pi.packageName);

        List<ResolveInfo> apps = pm.queryIntentActivities(resolveIntent, 0);

        ResolveInfo ri = null;
        try {
            ri = apps.iterator().next();
        } catch (Exception e) {
            return true;
        }
        if (ri != null) {
            String tmpPackageName = ri.activityInfo.packageName;
            String className = ri.activityInfo.name;

            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);

            ComponentName cn = new ComponentName(tmpPackageName, className);

            intent.setComponent(cn);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } else {
            return false;
        }
        return true;
    }


    /**
     * 安装apk
     *
     * @param filePath file path of package
     * @return whether apk exist
     */
    public static boolean installNormal(@NonNull Context context, @NonNull String filePath) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        File file = new File(filePath);
        if (!file.exists() || !file.isFile() || file.length() <= 0) {
            return false;
        }
        i.setDataAndType(Uri.parse("file://" + filePath),
                "application/vnd.android.package-archive");
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
        return true;
    }


    /**
     * 卸载apk
     *
     * @param packageName package name of app
     * @return whether package name is empty
     */
    public static boolean uninstallNormal(@NonNull Context context, @NonNull String packageName) {
        Intent i = new Intent(Intent.ACTION_DELETE, Uri.parse(
                new StringBuilder(32).append("package:").append(packageName).toString()));
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
        return true;
    }


    /**
     * 检测context是否为系统应用程序
     */
    public static boolean isSystemApplication(@NonNull Context context) {
        return isSystemApplication(context, context.getPackageName());
    }

    /**
     * 检测是否系统应用程序
     */
    public static boolean isSystemApplication(
            @NonNull Context context, @NonNull String packageName) {
        return isSystemApplication(context.getPackageManager(), packageName);
    }

    /**
     * 检测是否系统应用程序
     *
     * @return <ul>
     * <li>if packageManager is null, return false</li>
     * <li>if package name is null or is empty, return false</li>
     * <li>if package name not exit, return false</li>
     * <li>if package name exit, but not system app, return false</li>
     * <li>else return true</li>
     * </ul>
     */
    public static boolean isSystemApplication(
            @NonNull PackageManager packageManager, @NonNull String packageName) {
        try {
            ApplicationInfo app = packageManager.getApplicationInfo(packageName, 0);
            return (app != null && (app.flags & ApplicationInfo.FLAG_SYSTEM) > 0);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 检测应用是否在前台
     * <p>
     * Attentions:
     * <ul>
     * <li>You should add android.permission.GET_TASKS in manifest</li>
     * </ul>
     *
     * @return if params error or task stack is null, return null, otherwise retun whether the app
     * is on the top of
     * stack
     */
    public static Boolean isTopActivity(@NonNull Context context, @NonNull String packageName) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<RunningTaskInfo> tasksInfo = activityManager.getRunningTasks(1);
        if (tasksInfo != null && tasksInfo.size() > 0) {
            return false;
        }
        try {
            return packageName.equals(tasksInfo.get(0).topActivity.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
