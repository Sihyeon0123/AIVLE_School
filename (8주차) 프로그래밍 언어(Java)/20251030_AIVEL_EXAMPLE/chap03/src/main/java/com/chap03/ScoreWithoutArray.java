package com.chap03;

public class ScoreWithoutArray {
    public static void main(String[] args) {
        int score1 = 100;
        int score2 = 90;
        int score3 = 50;
        int score4 = 95;
        int score5 = 85;

        int sum = score1+score2+score3+score4+score5;
        double average = sum / 5.0;
        System.out.println("평균 점수 : "+average + ", 총점 : "+sum);
    }
}
