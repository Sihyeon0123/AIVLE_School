package com.chap05;

class Person0 {
    private String name;
    private int age;
    private String addr;

    public Person0(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}

@SuppressWarnings("unused")
class Person0Main {
    private String name;
    public static void main(String[] args) {
        Person0 person = new Person0("전길동");
        System.out.println("이름 : " + person.getName());
        person.setName("홍길동"); // person.name = "홍길동";
        System.out.println("변경된 이름 : " + person.getName());
    }
}


