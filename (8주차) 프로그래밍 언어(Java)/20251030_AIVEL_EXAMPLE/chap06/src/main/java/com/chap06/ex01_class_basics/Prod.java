package com.chap06.ex01_class_basics;

public class Prod {
    int id;
    String nm;
    public Prod(int i, String n) {
        this.id = i;
        this.nm = n;
    }
    void info(){
        System.out.println(id + " : " + nm);
    }
}

class ExtProd extends Prod{
    //i, nm
    int qty;
    String nm = "자식 인스턴스 변수";

    public ExtProd(int i, String n, int q) {
        super(i, n); // super : 부모객체, 부모객체+() : 부모 생성자 호출
        this.qty = q;
    }

    @Override
    void info() {
        // 부모 메소드를 재정의 하는 일
        // super.info(); // 부모객체의 info 메소드를 호출
        System.out.println(this.id + " : " + super.nm); // 상속관계 this.id -> super.id
        System.out.println("수량 : " + this.qty);
    }
}

class ProdMain{
    public static void main(String[] args) {
        //Prod p = new Prod(1,"pen");
        ExtProd ep = new ExtProd(2, "Notebook", 10);
        //p.info();
        ep.info();
    }
}