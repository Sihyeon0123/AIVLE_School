package com.chap10;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList<String> items = new LinkedList<>();
        items.add("Apple");
        items.add("Banana");
        items.addFirst("Orange");  // 리스트의 시작에 요소 추가
        items.addLast("Peach");    // 리스트의 끝에 요소 추가
        items.add(2, "Grapes");

        System.out.println("First Item: " + items.getFirst());
        System.out.println("Last Item: " + items.getLast());

        items.set(1, "Strawberry");

        items.removeFirst();       // 첫 번째 요소 제거
        items.removeLast();        // 마지막 요소 제거
        items.remove("Banana");    // 특정 요소 제거

        System.out.println("Initial LinkedList: " + items);
        Iterator<String> iterator = items.iterator();
        System.out.println("LinkedList after removals:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("Size of LinkedList: " + items.size());
        items.clear();
        System.out.println("Is the LinkedList empty? " + items.isEmpty());
    }
}
