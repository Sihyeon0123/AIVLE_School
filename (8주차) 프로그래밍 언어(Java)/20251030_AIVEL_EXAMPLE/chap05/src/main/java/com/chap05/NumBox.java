package com.chap05;

class NumBox {
    int value; // 필드(인스턴스 변수)

    public NumBox() {}

    public NumBox(int value) {
        this.value = value;
    }

    public void print(){
        System.out.println("객체의 필드 값은 " + value + "입니다.");
    }
}

class NumBoxMain{
    public static void main(String[] args) {
        NumBox box1 = new NumBox(); // 디폴트 생성자를 호출
        NumBox box2 = new NumBox(10); // value 필드를 초기화 하는 생성자 호출
        box1.print();
        box2.print();
    }
}