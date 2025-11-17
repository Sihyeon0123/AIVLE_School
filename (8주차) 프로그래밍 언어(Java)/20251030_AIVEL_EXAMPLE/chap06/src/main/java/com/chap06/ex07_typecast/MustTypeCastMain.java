package com.chap06.ex07_typecast;

public class MustTypeCastMain {

    public static void main(String[] args) {
        Person person = new Person("사람"); // Person 객체 생성
        Student student = new Student("학생",101);
        //person.introduce();
        //student.introduce(); // 부모개체의 메소드
        //student.showStudentId(); // 나의 메소드

        Student castedStudent = (Student)person;
        castedStudent.showStudentId();

        Person p = student;
        p.introduce();
        //p.showStudentId();

        // p는 Person 타입인데 Student 객체가 자동 형변환 한 객체

        Student s = (Student)p;
        s.showStudentId();

    }
}
