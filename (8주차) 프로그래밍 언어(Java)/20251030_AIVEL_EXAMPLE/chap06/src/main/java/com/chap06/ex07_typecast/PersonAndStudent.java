package com.chap06.ex07_typecast;

class Person{
    String name;
    public Person(String name) {
        this.name = name;
    }
    void whoami(){
        System.out.println("나는 " + name + "임.");
    }

    // 자신이 누구인지를 출력하는 메서드
    void introduce() {
        System.out.println("나는 " + name + "입니다.");
    }

}
class Student extends Person{
    int studentId; // 학생의 학번
    public Student(String name, int studentId) {
        super(name); //부모객체의 생성자
        this.studentId = studentId;
    }
    void work(){
        System.out.println("나는 공부함.");
    }
    // 학번을 출력하는 메서드
    void showStudentId() {
        System.out.println("학번 : " + studentId);
    }

    @Override
    void introduce() {
        super.introduce();
        System.out.println("학생 번호: " + studentId);
    }
}