package com.chap06.ex08_polymorphism;
class Person{
    String name = "사람";
    void whoami(){
        System.out.println("나는 "+name+ "입니다.");
    }
}

class Student extends Person{
    int number = 7;
    void work(){
        System.out.println("나는 "+number+"시간 동안 공부합니다.");
    }
}


public class TypeCastPolymorphismMain {
    public static void main(String[] args) {
        Person p = new Person();
        Student s = new Student();
        p = s; // 업케스트
        downCast(p);
        downCast(s);
    }
    public static void downCast(Person p){
        if(p instanceof Student){
            Student s = (Student)p;
            System.out.println("다운캐스팅 성공: Person -> Student");
            s.work();
        }else{
            System.out.println("다운캐스팅 불가: 객체가 Student 타입이 아님");
        }
    }
}