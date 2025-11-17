package com.chap02;

public class CalculationDemo {
    public static void main(String[] args) {
        int nC;
        Long lC;
        double dC; // 실수를 담을 수 있음

        /* 정수 나눗셈(설명글 == 주석) */
        nC = 5/2;
        System.out.println("nc (5 / 2 ) " + nC); // 출력값: 2

        //dC = 5/2; // 5(int) / 2(int) => 결과는 int : 2 -> dC(실수형 변수) : 2.0
        dC = 5/2.0;
        System.out.println("nc (5 / 2 ) " + dC); // 출력값: 2.5

        lC = 10000000 * 10000000L;
        System.out.println(lC);

        lC = -10000000 * 10000000L;
        System.out.println(lC);
    }
}
