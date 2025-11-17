package com.chap06.ex01_class_basics;

public class Vehicle {
    // 차량의 속도를 나타내는 필드
    private int speed;
    // 차량의 속도를 설정하는 메소드
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    // 차량의 속도를 가져오는 메소드
    public int getSpeed() {
        return speed;
    }
}

class Car extends Vehicle {
    // 자동차의 좌석 수를 나타내는 필드
    private int seatCount;

    // 자동차의 좌석 수를 설정하는 메소드
    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    // 자동차의 좌석 수를 가져오는 메소드
    public int getSeatCount() {
        return seatCount;
    }
}

// 실행을 위한 메인 클래스
class InheritMain {
    public static void main(String[] args) {
        // Car 클래스의 객체 생성
        Car myCar = new Car();

        // myCar -> Car타입 or Vehicle타입
        // 상속받은 setSpeed 메소드 사용
        // myCar.speed = 200;
        //myCar.seatCount = 10;
        myCar.setSpeed(100); // 차량 속도 설정 (부모에 메소드 -> speed private)
        myCar.setSeatCount(4); // 좌석 수 설정

        // 상태 출력
        System.out.println("속도: " + myCar.getSpeed() + "km/h");
        System.out.println("좌석 수: " + myCar.getSeatCount() + "개");
    }
}