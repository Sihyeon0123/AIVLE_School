package com.chap07.ex02_interface;
interface Movable{
    public abstract void move();
}
class Car implements Movable{
    @Override
    public void move() {
        System.out.println("차량이 움직입니다.");
    }
    public void show(){
        System.out.println("차량을 보여줍니다.");
    }
}

public class PolymorphismMain {
    public static void main(String[] args) {
        //자식클래스 객체가 자동 형변환으로
        //부모 인터페이스 타입으로 변경됨(자동형변환,다운케스트)
        Movable m = new Car();
        m.move();
        //m.show();
        if(m instanceof Car){
            Car c = (Car)m; // 업케스트(강제 형변환)
            c.show();
        }
    }
}
