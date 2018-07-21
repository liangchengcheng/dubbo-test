package com.gaoxi.utils;

import com.gaoxi.enumeration.BaseEnum;

public class EnumUtil {

    /**
     * 根据code获取枚举
     */
    public static <E extends Enum<?> & BaseEnum> E codeOf(Class<E> enumClass, int code) {
        E[] enumConstants = enumClass.getEnumConstants();
        for (E e : enumConstants) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }

    /**
     * 根据msg获取枚举
     */
    public static <E extends Enum<?> & BaseEnum> E msgOf(Class<E> enumClass, String msg) {
        E[] enumConstants = enumClass.getEnumConstants();
        for (E e : enumConstants) {
            if (e.getMsg().equals(msg)) {
                return e;
            }
        }
        return null;
    }
}
