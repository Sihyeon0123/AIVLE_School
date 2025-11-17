package com.chap03;

public class MultiDimensionalArrayDemo {
    public static void main(String[] args) {
        int[][] scores = {
            {100,90 ,50 ,95 ,85},
            {70 ,60 ,82 ,75 ,40},
            {90 ,80 ,70 ,60 ,50}
        };
        int firstRowFirstCol = scores[0][0];
        System.out.println("첫 번째 행의 첫 번째 점수 : " + firstRowFirstCol);

        int secondRowThirdCol = scores[1][2];
        System.out.println("두 번째 행의 세 번째 점수 : " + secondRowThirdCol);

        // 배열의 크기 출력
        System.out.println("2차원 배열의 행의 수 : " + scores.length);
        System.out.println("첫 번째 행의 열의 수 : " + scores[0].length);
        System.out.println("전체 원소의 수 : " + scores.length*scores[0].length);

        System.out.println("2차원 배열의 모든 점수:");
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                System.out.print(scores[i][j] + " ");
            }
            System.out.println();
        }
    }
}
