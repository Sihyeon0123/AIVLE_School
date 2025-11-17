package com.chap05;

public class Person {
    private String name;
    private int age;
    public Person setName(String name) {
        this.name = name;
        return this; // Person 타입의 객체(내 자신의 객체)
    }
    public Person setAge(int age) {
        this.age = age;
        return this;
    }
    public void hello() {
        System.out.println("안녕, 나는 " + name + "이고 " + age + "살이야.");
    }
}

class PersonMain{
    public static void main(String[] args) {
        Person person = new Person();
        int su = 2*(10+2);
        ((person.setName("민규")).setAge(99)).hello();
        String st = "안녕"; //s1객체

        System.out.println( st.charAt(0) );
        System.out.println( ("안녕").charAt(0) );

        Integer intObj = 1000;

        String strNum = "1000";
        int intNum= Integer.parseInt(strNum);
        intNum = intObj.parseInt("2000"); // Integer.parseInt("2000");
        //클래스명.정적메소드()
        System.out.println(intNum+2);

        double douPi = Math.PI; //클래스명(static)으로 접근, 대문자(상수 : final)
        System.out.println(douPi);
    }
}
