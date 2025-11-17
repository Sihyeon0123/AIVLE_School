package com.chap03;

public class ArrayIterationDemo {
    public static void main(String[] args) {
        int[] numbers = {0,1,2,3,4};

        for(int i=0; i < numbers.length; i++) {
            numbers[i]++; // numbers[0] = numbers[0]+1;
        }
        int sum = 0;
        for(int num : numbers){
            System.out.print(num + " ");
            sum+=num; //sum = sum + num;
        }
        System.out.println("총합 = "+ sum + ",평균 = " + sum / 5.0);
    }
}
