package com.chap04;

import java.util.Random;
import java.util.Scanner;
public class RPSGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("가위(1), 바위(2), 보(3) 중 하나를 선택하세요.");
        int palyer = sc.nextInt();
        int computer = rand.nextInt(3) + 1;
        String[] RPSValues = {"가위","바위","보"};

        if (palyer == computer) {
            System.out.println("컴퓨터와 나는 "+RPSValues[palyer-1]+"를 내서 비겼다.");
        } else if (
            (palyer == 1 && computer == 3) ||
            (palyer == 2 && computer == 1) ||
            (palyer == 3 && computer == 2)
        ) {
            System.out.println("나는 "+RPSValues[palyer-1]+"를 내고 컴퓨터는 "+RPSValues[computer-1]+"을 내서 내가 이겼다.");
        }else{
            System.out.println("나는 "+RPSValues[palyer-1]+"를 내고 컴퓨터는 "+RPSValues[computer-1]+"을 내서 내가 졌다.");
        }
        sc.close();
    }
}
