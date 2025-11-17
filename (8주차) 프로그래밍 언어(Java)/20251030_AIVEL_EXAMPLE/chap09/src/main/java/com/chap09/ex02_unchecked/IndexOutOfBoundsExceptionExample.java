package com.chap09.ex02_unchecked;

import java.util.ArrayList;
import java.util.List;

public class IndexOutOfBoundsExceptionExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(numbers.get(i));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("인덱스 " + i + "는 리스트 범위를 벗어났습니다.");
                break;
            }
        }
    }
}
