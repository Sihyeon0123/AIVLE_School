package com.chap05;

class Square {
    private double side;

    public Square() {
        this(1.0); // public Square(double side)
        //this.side = 1.0;
    }

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}

class SquareMain{
    public static void main(String[] args) {
        Square sqDefault = new Square();
        System.out.println("기본 사이드 길이: " + sqDefault.getSide());

        Square sqCustom = new Square(5.0);
        System.out.println("사용자 정의 사이드 길이: " + sqCustom.getSide());
    }
}
