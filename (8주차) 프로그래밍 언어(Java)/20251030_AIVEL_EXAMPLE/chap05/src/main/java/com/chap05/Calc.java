package com.chap05;

public class Calc {
    private double res = 0;
    static final double PI = Math.PI;
    static int objCount = 0; //Calc 타입으로 객체화된 횟수 계산

    public Calc() {
        objCount++;
    }

    public double area(double rad){
        res = Calc.PI * rad * rad;
        return res;
    }
    public static double circ(double rad) {
        // 내부에서 인스턴스 변수는 사용할 수 없다.
        // this 모르기 때문
        return 2 * Calc.PI * rad;
    }
}
@SuppressWarnings("unused")
class CalcMain{
    public static void main(String[] args) {
        Calc c = new Calc(); // 생성자
        Calc c1 = new Calc(); // 생성자
        Calc c2 = new Calc(); // 생성자
        Calc c3 = new Calc(); // 생성자

        double da = c.area(10);
        double dc = Calc.circ(10); // 클레스 메소드 호출, c.circ(10) -> Calc.circ(10)
        // c.PI == Calc.PI 동일한 변수 클레스변수 -> Calc.PI
        // c.PI -> Calc.PI
        System.out.println("넓이 : " + da + " 원주률 : "+ Calc.PI);
        System.out.println("둘레 : " + dc + " 원주률 : "+ Calc.PI);

        System.out.println("총 만들어진 객체의 수 : "+ Calc.objCount); // Calc.objCount
    }
}

