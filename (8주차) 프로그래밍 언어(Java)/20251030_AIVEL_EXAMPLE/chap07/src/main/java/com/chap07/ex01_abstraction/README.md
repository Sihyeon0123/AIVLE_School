# ex01_abstraction - 추상 클래스

> 추상 클래스를 통한 공통 기능 정의와 강제 구현을 학습합니다.

## 파일 구성

- `Shape.java` - 추상 클래스
- `Circle.java` - 원 클래스
- `Rectangle.java` - 사각형 클래스
- `AbstractMain.java` - 실행 클래스

## 추상 클래스란?

하나 이상의 **추상 메서드**를 포함하는 클래스입니다.

```java
abstract class Shape {
    // 추상 메서드 - 구현부 없음
    abstract void draw();

    // 일반 메서드 - 구현부 있음
    void displayInfo() {
        System.out.println("도형입니다.");
    }
}
```

## 주요 특징

### 1. 인스턴스화 불가
```java
Shape shape = new Shape();  // 컴파일 에러!
Shape shape = new Circle(); // OK
```

### 2. 추상 메서드 강제 구현
자식 클래스는 **반드시** 모든 추상 메서드를 구현해야 합니다.

```java
class Circle extends Shape {
    @Override
    void draw() {  // 반드시 구현
        System.out.println("원을 그립니다.");
    }
}
```

### 3. 일반 메서드 포함 가능
공통 기능을 일반 메서드로 제공할 수 있습니다.

```java
abstract class Shape {
    protected String color;

    // 일반 메서드 (공통 기능)
    void setColor(String color) {
        this.color = color;
    }

    // 추상 메서드 (강제 구현)
    abstract double calculateArea();
}
```

## 추상 클래스 vs 일반 클래스

| 특징 | 추상 클래스 | 일반 클래스 |
|------|------------|------------|
| 인스턴스 생성 | ❌ | ✅ |
| 추상 메서드 | ✅ | ❌ |
| 일반 메서드 | ✅ | ✅ |
| 상속 | 단일 상속 | 단일 상속 |
| 목적 | 공통 기능 + 강제 구현 | 객체 생성 |

## 예제 코드

### Shape.java - 추상 클래스
```java
abstract class Shape {
    abstract void draw();

    void displayInfo() {
        System.out.println("도형입니다.");
    }
}
```

### Circle.java - 구현 클래스
```java
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    void draw() {
        System.out.println("원 그림. 반지름: " + radius);
    }
}
```

### Rectangle.java - 구현 클래스
```java
class Rectangle extends Shape {
    private double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    void draw() {
        System.out.println("사각형 그림. " + width + "x" + height);
    }
}
```

## 언제 추상 클래스를 사용할까?

### 사용하는 경우
- 관련된 클래스들 간 **공통 코드**를 공유할 때
- 일부 메서드는 **구현을 강제**하고 싶을 때
- 상태(필드)를 가져야 할 때

### 예시
```java
abstract class Employee {
    protected String name;
    protected int id;

    // 공통 기능
    void displayInfo() {
        System.out.println(id + ": " + name);
    }

    // 강제 구현
    abstract double calculateSalary();
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}
```

## 템플릿 메서드 패턴

추상 클래스의 대표적인 활용 패턴입니다.

```java
abstract class Game {
    // 템플릿 메서드 (실행 순서 정의)
    final void play() {
        initialize();
        startPlay();
        endPlay();
    }

    // 추상 메서드 (하위 클래스가 구현)
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();
}

class Chess extends Game {
    void initialize() {
        System.out.println("체스판 준비");
    }
    void startPlay() {
        System.out.println("체스 게임 시작");
    }
    void endPlay() {
        System.out.println("체스 게임 종료");
    }
}
```

## 실행 방법

```bash
mvn exec:java -pl chap07 -Dexec.mainClass="com.chap07.ex01_abstraction.AbstractMain"
```

## 정리

- **추상 클래스**: 불완전한 클래스, 직접 인스턴스화 불가
- **추상 메서드**: 선언만 있고 구현 없음, 자식 클래스가 반드시 구현
- **목적**: 공통 기능 제공 + 특정 메서드 구현 강제

## 다음 단계

**ex02_interface**에서 인터페이스를 학습하고, 추상 클래스와의 차이를 이해하세요.
