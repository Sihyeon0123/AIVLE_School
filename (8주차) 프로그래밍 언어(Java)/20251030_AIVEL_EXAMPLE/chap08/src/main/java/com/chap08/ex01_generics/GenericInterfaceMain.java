package com.chap08.ex01_generics;
interface InterfaceGeneric<T>{
    T getValue();
}
class GenericInterfaceClass implements InterfaceGeneric<String>{
    @Override
    public String getValue() {
        return "일반 값";
    }
}
public class GenericInterfaceMain {
    public static void main(String[] args) {
        // GenericInterfaceClass 제너릭 타입???
        // 일반 클레스 처럼 객체화
        GenericInterfaceClass myGenericClass = new GenericInterfaceClass();
        // 구현된 메서드 호출 및 반환값 출력
        String value = myGenericClass.getValue();
        System.out.println(value);

        InterfaceGeneric<String> myGenericInterface = new GenericInterfaceClass();

        System.out.println(myGenericInterface.getValue());

        InterfaceGeneric<String> myGenericInterface2 = new InterfaceGeneric<>() {
            @Override
            public String getValue() {
                return "익명 클레스";
            }
        };

        System.out.println(myGenericInterface2.getValue());
    }
}
