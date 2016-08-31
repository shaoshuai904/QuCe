package com.maple.quce.utils;


import java.util.HashSet;
import java.util.List;

/**
 * @author maple
 * @time 16/4/14 下午5:37
 */

public class ListUtils {
    public ListUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static String toString(List list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(" -- " + i + " -- " + list.get(i) + " ; \n");
        }
        return sb.toString();
    }

    public static String toString(List list, String div) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i) + div);
        }
        return sb.toString();
    }

    public static boolean[] toArray(List<Boolean> list) {
        boolean[] booleans = new boolean[list.size()];
        for (int i = 0; i < list.size(); i++) {
            booleans[i] = list.get(i);
        }
        return booleans;
    }

    // 去重
    public static List removeDuplicate(List list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }

    // 是否全选
    public static boolean isSelectAll(List<Boolean> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == false) {
                return false;
            }
        }
        return true;
    }

    // 是否全不选
    public static boolean isUnSelectAll(List<Boolean> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == true) {
                return false;
            }
        }
        return true;
    }

}
