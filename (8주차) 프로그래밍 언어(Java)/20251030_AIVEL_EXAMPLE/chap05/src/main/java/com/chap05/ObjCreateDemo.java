package com.chap05;

class Item{
    public Item() {
    }

    void describe(){
        System.out.println("이것은 Item 클레스 타입의 객체 입니다.");
    }
}

public class ObjCreateDemo {
    public static void main(String[] args) {
        Item itm = null;
        System.out.println(itm);
        itm = new Item(); // 생성자를 만들지 않으면 기본 생성자 생략 가능
        itm.describe();
    }
}
