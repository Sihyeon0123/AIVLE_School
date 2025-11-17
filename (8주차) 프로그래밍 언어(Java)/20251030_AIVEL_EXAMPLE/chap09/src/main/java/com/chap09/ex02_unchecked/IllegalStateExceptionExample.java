package com.chap09.ex02_unchecked;

import java.util.ArrayList;
import java.util.ListIterator;

public class IllegalStateExceptionExample {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        ListIterator<Integer> iterator = list.listIterator();
        try {
            iterator.remove();
        }catch (IllegalStateException e){
            System.out.println("IllegalStateException 발생: " + e.getMessage());
        }

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }
}
