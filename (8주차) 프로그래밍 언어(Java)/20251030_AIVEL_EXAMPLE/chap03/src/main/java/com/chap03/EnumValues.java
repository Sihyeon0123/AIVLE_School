package com.chap03;

import java.util.Arrays;

enum Gender {
    MALE, FEMALE;
    public void printGenderInfo(){
        switch (this){
            case MALE :
                System.out.println("열거 타입의 이름 : " + name() + " " + this);
                System.out.println("상수 모음 : " + Arrays.toString(values()));
                System.out.println("순서 : " + ordinal());
                System.out.println(name() + " 병역의 의무가 있다.");
                break;
            case FEMALE:
                System.out.println("열거 타입의 이름 : " + name());
                System.out.println("상수 모음 : " + Arrays.toString(values()));
                System.out.println("순서 : " + ordinal());
                System.out.println(name() + " 병역의 의무가 없다.");
                break;
        }
    }
}
public class EnumValues {
    public static void main(String[] args) {
        Gender gender = Gender.MALE;
        gender.printGenderInfo();
        gender = Gender.FEMALE;
        gender.printGenderInfo();
    }
}
