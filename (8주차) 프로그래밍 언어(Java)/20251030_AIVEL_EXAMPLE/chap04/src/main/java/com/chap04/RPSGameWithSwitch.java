package com.chap04;

import java.util.Scanner;
import java.util.Random;
public class RPSGameWithSwitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("가위(1), 바위(2), 보(3) 중 하나를 선택하세요.");
        int player = sc.nextInt();
        int computer = rand.nextInt(3) + 1; // 1~3 사이의 랜덤한 수
        System.out.println("플레이어: " + choiceToString(player) + ", 컴퓨터: " + choiceToString(computer));

        switch (player) {
            case 1: // 플레이어가 가위를 냈을 때
                if (computer == 3) {
                    System.out.println("이겼다.");
                } else if (computer == 2) {
                    System.out.println("졌다.");
                } else {
                    System.out.println("비겼다.");
                }
                break;
            case 2: // 플레이어가 바위를 냈을 때
                if (computer == 1) {
                    System.out.println("이겼다.");
                } else if (computer == 3) {
                    System.out.println("졌다.");
                } else {
                    System.out.println("비겼다.");
                }
                break;
            case 3: // 플레이어가 보를 냈을 때
                if (computer == 2) {
                    System.out.println("이겼다.");
                } else if (computer == 1) {
                    System.out.println("졌다.");
                } else {
                    System.out.println("비겼다.");
                }
                break;
            default:
                System.out.println("잘못된 입력이다.");
                break;
        }
        sc.close();
    }

    private static String choiceToString(int choice) {
        switch (choice) {
            case 1: return "가위";
            case 2: return "바위";
            case 3: return "보";
            default: return "알 수 없음";
        }
    }
}