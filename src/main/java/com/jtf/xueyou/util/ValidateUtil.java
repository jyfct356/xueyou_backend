package com.jtf.xueyou.util;

public class ValidateUtil {
    public static boolean isStrLongerThan(String str, Integer len) {
        return str.length() > len;
    }

    public static boolean isStrNullorEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}
