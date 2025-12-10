package com.chap09.ex02_unchecked;

@SuppressWarnings("unused")
public class ArrayIndexOutOfBoundsExceptionExample {
    public static void main(String[] args) {
        int number = 0;
        int[] numbers = {1,2,3,4,5,6,7,8,9,10};
        for (int i = 0; i < 100; i++) {
            try {
                System.out.println(numbers[i]);
            }catch (ArrayIndexOutOfBoundsException e){
                break;
            }
        }
    }
}
