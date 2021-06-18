package com.liu.auth.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 将一个对象转成String或者Long或者Int类型
 */
public class ObjectUtils {
    /**
     * 将一个对象转成String类型
     * @param obj
     * @return
     */
    public static String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    /**
     * 将一个对象转成Long类型
     * @param obj
     * @return
     */
    public static Long toLong(Object obj) {
        if (obj == null) {
                return 0L;
            }
            if (obj instanceof Double || obj instanceof Float) {
                return Long.valueOf(StringUtils.substringBefore(obj.toString(), "."));
            }
            if (obj instanceof Number) {
                return Long.valueOf(obj.toString());
            }
            if (obj instanceof String) {
                return Long.valueOf(obj.toString());
            } else {
                return 0L;
        }
    }

    /**
     * 将传进来的值转成int类型
     * @param obj
     * @return
     */
    public static Integer toInt(Object obj) {
        return toLong(obj).intValue();
    }
}