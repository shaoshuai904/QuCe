package com.maple.quce.bean;


/**
 * 题目单元
 *
 * @author maple
 * @time 16/10/19 下午2:16
 */
public class TiMu {

    public String timu;
    public Daan daan;


    public enum Daan {
        YES, NO, NULL
    }

    public TiMu() {
    }

    public TiMu(String timu, Daan daan) {
        this.timu = timu;
        this.daan = daan;
    }

    // 是否填写了答案
    public boolean isZuo() {
        return (daan != Daan.NULL);
    }

    @Override
    public String toString() {
        return "TiMu{" +
                "timu='" + timu + '\'' +
                ", daan=" + daan +
                '}';
    }
}
