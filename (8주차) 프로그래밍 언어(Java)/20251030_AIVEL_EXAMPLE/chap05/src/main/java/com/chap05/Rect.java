package com.chap05;

class Rect {
    private double width;
    private double height;
    // 오버로딩 : 이름이 같고 인자 값이 틀리면 서로 다른 메소드로 인식(메소드)
    // 생성자 == 메소드(특별한 메소드 : 객체화될때 필드를 초기화 하는 목적에 처음에 호출되는 메소드)
    public Rect() {
        this.width = 1.0;
        this.height = 1.0;
    }
    public Rect(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void printSize(){
        System.out.println("너비 : " + this.width
                + ", 높이 : " + this.height);
    }

}

class RectMain{
    public static void main(String[] args) {
        Rect r1 = new Rect();
        Rect r2 = new Rect(2.0, 3.0);

        r1.printSize();
        r2.printSize();
    }
}
