package com.chap10;

import java.util.LinkedList;
import java.util.Queue;

public class QueueMain {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("첫 번째");
        queue.add("두 번째");
        queue.add("세 번째");

        System.out.println(queue.peek());
        System.out.println(queue.element());
        System.out.println(queue.poll());
        System.out.println(queue.remove());
        System.out.println(queue);
        queue.clear();
        System.out.println(queue.size());
    }
}
