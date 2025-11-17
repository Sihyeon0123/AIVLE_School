package com.chap09.ex02_unchecked;
class Car{
    private String model;

    public Car(String model) {
        this.model = model;
    }

    public void display() {
        System.out.println("Car model: " + model);
    }

}
class ElectricCar extends Car{
    public ElectricCar(String model) {
        super(model);
    }
    public void charge() {
        System.out.println("Electric car is charging.");
    }
}

public class ClassCastExceptionCarClassExample {
    public static void main(String[] args) {
        Car car = new ElectricCar("Generic Car"); // 자동 형변환(원 객체는 ElectricCar Type, 다운 캐스트 됨)
        ElectricCar electricCar;

        try {
            // car Car타입의 객체(순수 부모 객체)
            // ElectricCar Type로 UpCast 시도
            electricCar = (ElectricCar) car;
            electricCar.charge();
        }catch (ClassCastException e){
            System.out.println("잘못된 타입으로 캐스팅하였습니다: " + e.getMessage());
        }
    }
}
