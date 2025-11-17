package com.chap08.ex01_generics;
class GenericClass<T>{
    private T data;
    public void setData(T data) {
        this.data = data;
    }
    public T getData() {
        return this.data; // 리턴이 T 타입, 타입은 외부에서 객체화 될때 결정
    }
}

public class GenericMain {
    public static void main(String[] args) {
        GenericClass<String> stringInstance = new GenericClass<>();
        stringInstance.setData("안녕, 제네릭");
        String data = stringInstance.getData();
        System.out.println(data);

        GenericClass<Integer> intInstance = new GenericClass<Integer>();
        intInstance.setData(123);
        Integer intData = intInstance.getData();
        System.out.println(intData);
    }
}
