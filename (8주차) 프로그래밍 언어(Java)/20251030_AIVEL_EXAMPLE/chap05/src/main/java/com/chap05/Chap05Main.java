package com.chap05;

public class Chap05Main {
    public static void main(String[] args) {

        Circle myCircle;
        myCircle = new Circle(2.0);
        // myCircle.radius = 3.0; //정보은폐 규칙 위배
        System.out.println("원의 넓이 : " + myCircle.findArea());

        Cls ball1 = new Cls(2.0); // 처음 호출하는 메소드(맴버변수 값들을 초기화)
        Cls ball2 = new Cls(4.0);

        System.out.println("1번째 공의 부피 : " + ball1.getVolume());
        System.out.println("2번째 공의 부피 : " + ball2.getVolume());

        // 캡슐화에 위배
        ball1.setradius(3.0); //ball1.radius = 3.0;
        ball2.setradius(4.5); //ball2.radius = 4.5;
        System.out.println("1번째 공의 부피 : " + ball1.getVolume());
        System.out.println("2번째 공의 부피 : " + ball2.getVolume());

        System.out.println("1번째 공의 표면적 : " + ball1.getArea());
        System.out.println("2번째 공의 표면적 : " + ball2.getArea());

    }
}
