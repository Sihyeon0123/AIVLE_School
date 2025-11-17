package com.chap06.ex02_inheritance;

class Animal {
    int eye;
    int mouth;
    String name;

    public Animal(String name, int eye, int mouth) {
        this.name = name;
        this.eye = eye;
        this.mouth = mouth;
    }

    void eat(){
        System.out.println(name+"는 "+mouth+"개의 입으로 먹는 중...");
    }
    void sleep(){
        System.out.println(name+"는 "+eye+"개의 눈을 감고 자는 중...");
    }
}

class Eagle extends Animal{
    int wing;

    public Eagle(String name, int eye, int mouth, int wing) {
        super(name, eye, mouth);
        this.wing = wing;
    }

    void fly(){
        System.out.println(name+"는 "+wing+"개의 날개로 날아다니는 중...");
    }
}
class Tiger extends Animal{
    int leg;

    public Tiger(String name, int eye, int mouth, int leg) {
        super(name, eye, mouth);
        this.leg = leg;
    }

    void run(){
        System.out.println(name+"는 "+leg + "개의 다리로 달리는 중...");
    }
}

class GoldFish extends Animal{
    int fin;

    public GoldFish(String name, int eye, int mouth, int fin) {
        super(name, eye, mouth);
        this.fin = fin;
    }

    void swim(){
        System.out.println(name+"는 "+fin + "개의 지느러미로 헤염치는 중...");
    }
}

class AnimalMain{
    public static void main(String[] args) {
        Eagle eagle = new Eagle("독수리", 2, 1, 2); // 독수리 객체 생성
        Tiger tiger = new Tiger("호랑이", 2,1,4); // 호랑이 객체 생성
        GoldFish goldfish = new GoldFish("금붕어", 2,1,4); // 금붕어 객체 생성

        // 각 동물의 행동을 테스트
        eagle.fly();
        eagle.eat(); // 부모 메소드
        eagle.sleep(); // 부모 메소드

        tiger.run();
        tiger.eat(); // 부모 메소드
        tiger.sleep(); // 부모 메소드

        goldfish.swim();
        goldfish.eat(); // 부모 메소드
        goldfish.sleep(); // 부모 메소드
    }
}

