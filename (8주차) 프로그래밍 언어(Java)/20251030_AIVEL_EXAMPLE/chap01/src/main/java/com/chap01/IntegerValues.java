package com.chap01;

public class IntegerValues {
    public static void main(String[] args) {
        byte maxByte = Byte.MAX_VALUE;
        byte minByte = Byte.MIN_VALUE;
        short maxShort = Short.MAX_VALUE;
        short minShort = Short.MIN_VALUE;
        int maxInt = Integer.MAX_VALUE;
        int minInt = Integer.MIN_VALUE;
        long maxlong = Long.MAX_VALUE;
        long minlong = Long.MIN_VALUE;

        System.out.println("byte 최대값 : " + maxByte);
        System.out.println("byte 최소값 : " + minByte);
        System.out.println("short 최대값 : " + maxShort);
        System.out.println("short 최소값 : " + minShort);
        System.out.println("int 최대값 : " + maxInt);
        System.out.println("int 최소값 : " + minInt);
        System.out.println("Long 최대값 : " + maxlong);
        System.out.println("Long 최소값 : " + minlong);
    }
}
