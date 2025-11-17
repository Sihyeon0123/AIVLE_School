package com.chap09.ex02_unchecked;

import java.util.Scanner;

public class CalculateAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int count = 0;
        System.out.println("성적을 입력하세요. 입력을 마치려면 엔터를 치세요.");

        while (true){
            System.out.print((count + 1) + "번 학생의 성적: ");
            String input = scanner.nextLine();
            // 사용자가 엔터를 쳐서 입력을 종료하는 경우 확인
            if (input.isEmpty()) {
                break;
            }
            int score = 0;

            try {
                score = Integer.parseInt(input);
            }catch (NumberFormatException e){
                System.out.println("잘못 입력 하셨습니다. 숫자를 입력 하세요!");
                continue;
            }
            sum += score;
            count++;
        }

        try {
            double average = sum / count;
            System.out.println("입력된 성적의 평균: " + average);
        }catch (ArithmeticException e){
            System.out.println("입력된 학생의 점수가 없습니다. 다시 실행하세요.");
        }

    }
}
