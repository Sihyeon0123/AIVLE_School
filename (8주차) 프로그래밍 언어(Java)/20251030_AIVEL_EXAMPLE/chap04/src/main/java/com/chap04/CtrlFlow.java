package com.chap04;

public class CtrlFlow {
    public static void main(String[] args) {
        int n = 1, s = 0;
        while (true){ // 무한반복
            s += n;
            if(n == 100){
                break;
            }
            n++;
        }
        //5050
        System.out.println("1~100 누적 합 : " + s);

        for (int i = 1; i <= 100; i++) {
            if(!(i%5 == 0 || i%7 == 0)){
                continue;
            }
            System.out.println(i + "는 5 또는 7의 배수");
        }
    }
}
