package com.chap10;

class Node {
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class CustomLinkedList {
    Node head;

    public CustomLinkedList() {
        this.head = null;
    }

    public void add(String data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
        }
        else {
            Node last = this.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class CustomLinkedListMain {
    public static void main(String[] args) {
        CustomLinkedList myList = new CustomLinkedList();
        myList.add("Apple");
        myList.add("Banana");
        myList.add("Cherry");

        myList.display();
    }
}