package com.maple.quce.utils;


import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;


/**
 * 设备信息工具类
 *
 * @author maple
 * @time 16/4/26 下午3:14
 */
public class DeviceUtils {

    private DeviceUtils() {

        throw new UnsupportedOperationException("cannot be instantiated");
    }


    public String getInfo(Context context) {
        TelephonyManager mTelephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String mAndroidId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        String deviceId = mTelephonyManager.getDeviceId();// 返回当前移动终端的唯一标识
        String number = mTelephonyManager.getLine1Number(); //返回手机号码 (可能为空)
        String subscriberId = mTelephonyManager.getSubscriberId();//返回用户唯一标识，比如GSM网络的IMSI编号
        GsmCellLocation location = (GsmCellLocation) mTelephonyManager.getCellLocation();//返回设备的当前位置
        String simSerialNumber = mTelephonyManager.getSimSerialNumber();//返回SIM卡的序列号(IMEI) 注意：对于CDMA设备，返回的是一个空值！
        String serialNumber = Build.SERIAL;// 返回序列号 (Android 2.3以上可以使用此方法)
        int type = mTelephonyManager.getPhoneType();//返回移动终端的类型
        int networkType = mTelephonyManager.getNetworkType();//获取网络类型

        StringBuffer sb = new StringBuffer("设备信息：\n");
        sb.append("手机品牌:").append(getBrand()).append("\n");
        sb.append("手机型号:").append(getModel()).append("\n");
        sb.append("SDK版本:").append(getSdkVersion()).append("\n");
        sb.append("系统版本:").append(getUserVersion()).append("\n");
        sb.append("硬件名称:").append(getHardware()).append("\n");
        sb.append("getAndroidId:").append(mAndroidId).append("\n");
        sb.append("getDeviceId:").append(deviceId).append("\n");
        sb.append("getNumber:").append(number).append("\n");
        sb.append("getSubscriberId:").append(subscriberId).append("\n");
        sb.append("getSimSerialNumber:").append(simSerialNumber).append("\n");
        sb.append("getSerialNumber:").append(serialNumber).append("\n");
        sb.append("getPhoneType:").append(type).append("\n");
        sb.append("getNetworkType:").append(networkType).append("\n");
        Log.d("Device info", sb.toString());
        return sb.toString();
    }


    /** 手机品牌 */
    public String getBrand() {
        return Build.BRAND;
    }

    /** 手机型号 */
    public String getModel() {
        return Build.MODEL;
    }

    /** sdk版本 */
    public int getSdkVersion() {
        return Build.VERSION.SDK_INT;
    }

    /** 系统版本 */
    public String getUserVersion() {
        return Build.VERSION.RELEASE;
    }

    /** 硬件名称 */
    public String getHardware() {
        return Build.HARDWARE;
    }
}


