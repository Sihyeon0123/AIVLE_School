package com.chap03;

// 열거 타입 CardType 정의
enum CardType {
    DEBIT, CREDIT, PREPAID
    // 필드, 생성자, 메서드 등 추가 가능
}

public class EnumExample {

    public static void main(String[ ] args) {
        // CardType 열거 타입 변수 선언 및 초기화
        CardType myCardType = CardType.DEBIT;

        // 열거 타입 값에 따라 다른 행동을 하는 switch 문
        switch (myCardType) {
            case DEBIT:
                System.out.println("직불 카드를 선택했습니다.");
                break;
            case CREDIT:
                System.out.println("신용 카드를 선택했습니다.");
                break;
            case PREPAID:
                System.out.println("선불 카드를 선택했습니다.");
                break;
            default:
                System.out.println("알 수 없는 카드 타입입니다.");
        }
    }
}