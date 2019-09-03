package com.jd.utils;

public class StringUtil {
    public static boolean isEmpty(String s){
        return isNull(s) || "".equals(s);
    }

    public static boolean isNull(String s){
        return null == s;
    }

    public static boolean isBlank(String s){
        if(isNull(s)){
            return true;
        }

        return isEmpty(s.trim());
    }
}
