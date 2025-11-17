package com.chap06.ex07_typecast;

public class TypeCheckMain {
    public static void main(String[] args) {
        Person person = new Person("김철수");
        Student student = new Student("이영희",123456);
        /*
        if(person instanceof Person){
            System.out.println("person은 Person 클레스의 인스턴스임");
        }
        if(student instanceof Person){
            System.out.println("student는 Person 클레스의 인스턴스임 (상속)");
        }
        if(student instanceof Student){
            System.out.println("student는 Student 클레스의 인스턴스임");
        }
        */

        // Student로 변환할 수 있는지 확인
        if(person instanceof Student) {
            Student castedStudent = (Student) person;
            castedStudent.introduce();
        } else {
            System.out.println("person은 Student로 변환 불가.");
        }

        //student.showStudentId();
        Person p = student; // 업케스트 하면서 기능 부모 기능으로 축소
        //p.introduce(); // 자식 객체의 메소드 호출 이름 출력 학생번호(오버라이드)
        //p.showStudentId();
        // 다운캐스팅 가능 여부 확인 및 변환
        if(p instanceof Student) {
            Student s = (Student) p;
            s.introduce();
        }
    }
}
