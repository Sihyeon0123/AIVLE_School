package com.chap07.ex01_abstraction;
// 'Person' 클래스는 'Comparable' 인터페이스를 구현합니다.
// 'Person' 객체들은 나이를 기준으로 비교될 수 있습니다.
public class Person implements Comparable<Person>{
    private int age;

    public Person(int age) {
        this.age = age;
    }
    @Override
    public int compareTo(Person o) {
        return Integer.compare(this.age, o.age);
    }
    // 'Person' 객체의 정보를 출력하는 메서드
    public void printInfo() {
        System.out.println("나는 " + age + "살이다.");
    }
}
