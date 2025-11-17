package com.chap02;

public class ShiftOperationDemo {
    public static void main(String[] args) {
        int originalValue = 0x80000039; // 초기값 설정
        int result = 0; // 연산 결과를 저장할 변수

        System.out.printf(" 초기 값 : %d\t\n", originalValue);

        // 부호 있는 오른쪽 시프트 연산 -268435448.875 -> -268435449
        result = originalValue >> 3; // -2147483591 / 8
        System.out.printf("'>>' 연산결과 : 0x%08x (%d)\t\n", result, result);

        // 부호 없는 오른쪽 시프트 연산
        result = originalValue >>> 3; // 2147483591 / 8 -> 268435463
        System.out.printf("'>>>' 연산결과 : 0x%08x (%d)\t\n", result, result);

        // 왼쪽 시프트 연산
        result = 4 << 3; // 4*(2^3) = 4*8
        System.out.printf("'<<' 연산결과 : 0x%08x (%d)\t\n", result, result);
    }
}
