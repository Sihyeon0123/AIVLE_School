# ex01_basics - 기본 상속 개념

> 상속의 기본 개념과 문법을 학습합니다.

## 학습 목표

- `extends` 키워드로 상속 구현
- 부모 클래스의 멤버 접근
- 메서드 오버라이딩의 기초
- `super` 키워드 사용

## 파일 구성

- `Vehicle.java` - 부모 클래스 (탈것)
- `Car.java` - 자식 클래스 (자동차)
- `BasicInheritanceMain.java` - 실행 클래스

## 핵심 개념

### 상속이란?

기존 클래스(부모 클래스)의 필드와 메서드를 새로운 클래스(자식 클래스)가 물려받는 것입니다.

```java
class Vehicle {              // 부모 클래스
    protected int speed;

    public void move() {
        System.out.println("이동합니다.");
    }
}

class Car extends Vehicle {  // 자식 클래스
    // Vehicle의 speed와 move() 상속
    private String brand;

    public void honk() {
        System.out.println("빵빵!");
    }
}
```

### 상속의 장점

1. **코드 재사용**: 중복 코드 제거
2. **계층적 분류**: 개념을 체계적으로 구조화
3. **유지보수성**: 공통 기능을 한 곳에서 관리

## 주요 개념

### 1. extends 키워드
```java
class Child extends Parent {
    // Parent의 public, protected 멤버 상속
}
```

### 2. protected 접근 제어자
- 같은 패키지 또는 상속받은 클래스에서 접근 가능
- 상속 관계에서 자주 사용

### 3. 메서드 오버라이딩
부모 클래스의 메서드를 자식 클래스에서 재정의

```java
@Override
public void move() {
    System.out.println("자동차가 달립니다.");
}
```

### 4. super 키워드
- 부모 클래스의 멤버 접근
- 부모 생성자 호출

```java
public Car(String brand, int speed) {
    super();  // 부모 생성자 호출
    this.brand = brand;
}
```

## 실행 방법

### IntelliJ에서 실행
1. `BasicInheritanceMain.java` 열기
2. 실행 버튼(▶) 클릭

### 명령줄에서 실행
```bash
mvn exec:java -pl chap06 -Dexec.mainClass="com.chap06.ex01_basics.BasicInheritanceMain"
```

## 예상 결과

Vehicle과 Car 객체의 생성 및 메서드 호출 결과가 출력됩니다.

## 연습 문제

1. `Bicycle` 클래스를 추가로 만들어 `Vehicle`을 상속받아보세요.
2. `Bicycle` 클래스에 `ringBell()` 메서드를 추가해보세요.
3. `move()` 메서드를 오버라이딩하여 "자전거가 달립니다." 출력해보세요.

## 다음 단계

**ex02_animals**에서 실용적인 상속 예제를 통해 개념을 강화하세요.
