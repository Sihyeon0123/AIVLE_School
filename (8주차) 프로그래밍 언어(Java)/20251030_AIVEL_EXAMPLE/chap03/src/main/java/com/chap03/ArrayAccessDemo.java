package com.chap03;

public class ArrayAccessDemo {
    public static void main(String[] args) {
        int[] scores = {100,90,50,95,85};

        int firstScore = scores[0];
        System.out.println("첫 번째 점수 : " + firstScore);

        int lastScore = scores[scores.length-1];
        System.out.println("마지막 점수 : " + lastScore);
        System.out.println("배열에 크기 : " + scores.length);

        System.out.println("배열의 모든 원소 : ");
        for(int i = 0; i < scores.length ; i++) {
            System.out.println("원소 " + i + " : " + scores[i]);
        }
    }
}
