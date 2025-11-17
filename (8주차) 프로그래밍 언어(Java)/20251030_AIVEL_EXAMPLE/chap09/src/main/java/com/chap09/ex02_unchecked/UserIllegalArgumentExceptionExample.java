package com.chap09.ex02_unchecked;
class Person{
    private int age;
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("나이는 0보다 작을 수 없습니다.");
        }
        this.age = age;
    }
    public int getAge() {
        return age;
    }
}

public class UserIllegalArgumentExceptionExample {
    public static void main(String[] args) {
        Person person = new Person();
        try{
            person.setAge(-5);
        }catch (IllegalArgumentException e){
            System.out.println("IllegalArgumentException 발생: " + e.getMessage());
        }
    }
}
