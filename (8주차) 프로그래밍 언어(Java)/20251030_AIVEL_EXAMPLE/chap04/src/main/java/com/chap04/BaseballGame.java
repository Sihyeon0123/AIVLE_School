package com.chap04;

import java.util.Random;
import java.util.Scanner;

public class BaseballGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int[] computerNumbers = new int[3];
        for (int i = 0; i < 3; i++) {
            computerNumbers[i] = rand.nextInt(9)+1;
            for (int j = 0; j < i; j++) {
                if(computerNumbers[i] == computerNumbers[j]){
                    i++;
                    break;
                }
            }
        }
        int gameCount = 0;
        boolean isGameFinished = false;
        while (!isGameFinished){
            gameCount++;
            int strike = 0;
            int ball = 0;
            System.out.println(gameCount +"번째 기회, 숫자 입력 : ");
            String playerGuess = sc.nextLine();
            int[] playNumbers = new int[3];

            for (int i = 0; i < 3; i++) {
                //'0'의 아스키코드는 48, '1'의 아스키코드는 49 (49-48)
                playNumbers[i] = playerGuess.charAt(i) - '0';
                //System.out.print(playNumbers[i] + " ");
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(playNumbers[i] == computerNumbers[j]){
                        if(i == j){
                            strike++;
                        }else{
                            ball++;
                        }
                    }
                }
            }
            if(strike == 3){
                System.out.println("축하합니다. 이겼어요!!");
                isGameFinished = true;
            }else if(strike > 0 || ball > 0) {
                System.out.println(strike + " 스트라이크 " + ball + " 볼");
            }else{
                System.out.println("아웃");
            }
            if (gameCount >= 10) {
                System.out.println("모든 기회를 소진 했습니다. 당신이 졌습니다.");
                break;
            }
        }
        sc.close();
    }
}