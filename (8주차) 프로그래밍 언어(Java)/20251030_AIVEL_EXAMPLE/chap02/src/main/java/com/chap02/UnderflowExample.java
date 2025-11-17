package com.chap02;

public class UnderflowExample {
    public static void main(String[] args) {
        double smallDouble = 1e-300;
        double underflowExample = smallDouble * smallDouble;

        System.out.println("Small double Value : " + smallDouble);
        System.out.println("underflow Result : " + underflowExample);
    }

}
