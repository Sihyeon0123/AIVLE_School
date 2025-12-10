package com.chap07.ex01_abstraction;

public class ComparableMain {
    public static void main(String[] args) {
        Comparable<Person> person1 = new Person(25);
        Comparable<Person> person2 = new Person(30);

        // compareTo 오버라이드(재정의), 기존 Comparable<T> 인터페이스 추상 메서드
        int result = person1.compareTo((Person) person2);

        if(result < 0){
            System.out.println("person1이 person2보다 어립니다.");
        }else if(result > 0){
            System.out.println("person1이 person2보다 나이가 많습니다.");
        }else{
            System.out.println("person1와 person2는 동갑입니다.");
        }
    }
}
