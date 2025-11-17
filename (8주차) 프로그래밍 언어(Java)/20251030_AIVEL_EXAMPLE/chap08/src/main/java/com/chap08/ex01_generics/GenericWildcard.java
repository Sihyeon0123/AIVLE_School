package com.chap08.ex01_generics;
import java.util.ArrayList;
import java.util.List;
class GenericWildcard{
    public void printList(List<?> list){
        for(Object obj : list){
            System.out.print(obj + " ");
        }
        System.out.println();
    }
    public double sumOfList(List<? extends Number> list){
        double sum = 0.0;
        for(Number num : list){
            sum += (double)num;
            //sum += num.doubleValue();
        }
        return sum;
    }
    public void addNumber(List<? super Integer> list){
        for (int i = 1; i <= 5 ; i++) {
            list.add(i);
        }
    }

    public static void main(String[] args) {
        GenericWildcard A = new GenericWildcard();
        List<String> list1 = new ArrayList<>();
        list1.add("10.0");
        list1.add("20.1");
        A.printList(list1);

        List<Double> list2 = new ArrayList<>();
        list2.add(10.5);
        list2.add(20.5);
        System.out.println("합계: " + A.sumOfList(list2)); // Number 또는 그 하위 타입만 가능

        // 와일드카드 super 사용 - 정수 추가
        List<Number> list3 = new ArrayList<>();
        A.addNumber(list3); // Integer 또는 그 상위 타입만 가능
        A.printList(list3);
    }
}