package com.chap02;

public class TypeConversionExample {
    public static void main(String[] args) {
        // byte byteValue = 10;
        short shortValue = 20;
        int intValue = 10;
        long longValue = 30L;
        double doubleValue = 2.5;
        // int intResult1 = 0, intResult2 = 0;
        // long longResult = 0L;
        // double doubleResult = 0;
        Object obj;

        obj = shortValue;
        System.out.println(obj.getClass().getName());
        obj = shortValue / intValue;
        System.out.println(obj.getClass().getName());
        obj = intValue * longValue;
        System.out.println(obj.getClass().getName());
        obj = intValue / doubleValue;
        System.out.println(obj.getClass().getName());
    }
}
