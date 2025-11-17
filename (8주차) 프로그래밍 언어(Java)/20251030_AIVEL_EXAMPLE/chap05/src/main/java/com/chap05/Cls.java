package com.chap05;

class Cls {
    // 필드 영역(맴버 변수)
    private double radius;

    public Cls(double radius) { // 생성자(스페셜한 메소드)
        // 매개인수 -> 메소드내에서 지역 변수 사용
        this.radius = radius;
    }

    public double getVolume(){
        return 4.0/3.0 * Math.PI * Math.pow(radius, 3); // Math.pow(radius, 3); 2.0의 3
    }

    public double getArea(){
        return 4 * Math.PI * radius * radius;
    }

    public void setradius(double radius) {
        this.radius = radius;
    }
}
