package com.chap03;

public class ArrayCreationDemo {
    public static void main(String[] args) {
        int[] scoreMethod1 = {100,90,50,95,85};
        int[] scoreMethod2 = new int[] {100,90,50,94,85};
        int[] scoreMethod3;
        scoreMethod3 = new int[] {100,90,50,94,85};

        System.out.println("방법1");
        for(int score : scoreMethod1){
            System.out.print(score + " ");
        }
        System.out.println();
        System.out.println("방법2");
        for(int score : scoreMethod2){
            System.out.print(score + " ");
        }
        System.out.println();
        System.out.println("방법3");
        for (int i = 0; i < scoreMethod3.length; i++) {
            System.out.print(scoreMethod3[i] + " ");
        }
        System.out.println();
    }
}
