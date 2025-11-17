# Chapter 07: 추상화

> 추상 클래스와 인터페이스를 통해 강력한 추상화 기법을 학습합니다.

## 학습 목표

- 추상 클래스의 개념과 활용
- 인터페이스의 역할 이해
- 디폴트 메서드와 정적 메서드
- 다중 인터페이스 구현
- 중첩 클래스와 익명 클래스
- 추상화를 통한 설계 능력 향상

## 패키지 구조

```
com.chap07/
├── ex01_abstraction/      # 추상 클래스
├── ex02_interface/        # 인터페이스
└── ex03_nested/           # 중첩 클래스와 익명 클래스
```

## 예제별 상세 내용

### ex01_abstraction - 추상 클래스

**파일**: `Shape.java`, `Circle.java`, `Rectangle.java`, `AbstractMain.java`

추상 클래스를 통한 공통 기능 정의와 강제 구현을 학습합니다.

```java
abstract class Shape {
    // 추상 메서드 - 반드시 구현해야 함
    abstract void draw();

    // 일반 메서드 - 공통 기능 제공
    void displayInfo() {
        System.out.println("도형입니다.");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("원을 그립니다.");
    }
}
```

**주요 특징**:
- `abstract` 키워드로 추상 클래스 선언
- 추상 메서드는 구현부가 없음
- 일반 메서드도 포함 가능
- 직접 인스턴스화 불가능

**학습 포인트**:
- 추상 클래스의 필요성
- 추상 메서드 강제 구현
- 템플릿 메서드 패턴

**실행**: `AbstractMain.java`

---

### ex02_interface - 인터페이스

이 패키지는 인터페이스의 다양한 기능을 다룹니다.

#### InterfaceMain.java - 기본 인터페이스
인터페이스의 기본 개념과 다중 구현을 학습합니다.

```java
interface Drawable {
    void draw();  // public abstract 생략 가능
}

interface Colorable {
    void setColor(String color);
}

// 다중 인터페이스 구현
class Shape implements Drawable, Colorable {
    @Override
    public void draw() { }

    @Override
    public void setColor(String color) { }
}
```

**학습 포인트**:
- 인터페이스 선언과 구현
- 다중 인터페이스 구현
- 추상 클래스 vs 인터페이스

#### DefaultMethodMain.java - 디폴트 메서드
Java 8부터 추가된 디폴트 메서드를 학습합니다.

```java
interface A {
    void method1();  // 추상 메서드

    default void method2() {  // 디폴트 메서드
        System.out.println("디폴트 메서드");
    }
}

class C1 implements A {
    @Override
    public void method1() {
        // 반드시 구현
    }
    // method2()는 선택적 오버라이드
}

class D1 implements A {
    @Override
    public void method1() { }

    @Override
    public void method2() {
        // 디폴트 메서드 재정의
    }
}
```

**디폴트 메서드의 장점**:
- 인터페이스 확장 시 기존 코드 호환성 유지
- 공통 기능 제공 가능
- 선택적 오버라이드

**학습 포인트**:
- 디폴트 메서드 선언과 사용
- 선택적 오버라이딩
- 인터페이스 진화 전략

#### PolymorphismMain.java - 인터페이스와 다형성
인터페이스를 활용한 다형성을 학습합니다.

```java
interface Animal {
    void sound();
}

class Dog implements Animal {
    public void sound() {
        System.out.println("멍멍");
    }
}

class Cat implements Animal {
    public void sound() {
        System.out.println("야옹");
    }
}

// 다형성 활용
Animal[] animals = {new Dog(), new Cat()};
for (Animal animal : animals) {
    animal.sound();  // 각자의 소리
}
```

**학습 포인트**:
- 인터페이스 타입 참조
- 다형성을 통한 유연한 설계
- 의존성 역전 원칙 (DIP)

**실행**: `InterfaceMain.java`, `DefaultMethodMain.java`, `PolymorphismMain.java`

---

### ex03_nested - 중첩 클래스와 익명 클래스

**파일**: `OuterClass.java`, `AnonymousClassMain.java`

중첩 클래스와 익명 클래스의 활용법을 학습합니다.

#### 중첩 클래스 (Nested Class)
```java
class OuterClass {
    private int outerField = 10;

    // 내부 클래스
    class InnerClass {
        void display() {
            // 외부 클래스의 멤버 접근 가능
            System.out.println(outerField);
        }
    }

    // 정적 중첩 클래스
    static class StaticNestedClass {
        void display() {
            // 외부 클래스의 static 멤버만 접근 가능
        }
    }
}
```

#### 익명 클래스 (Anonymous Class)
```java
interface Greeting {
    void sayHello();
}

// 익명 클래스로 인터페이스 구현
Greeting greeting = new Greeting() {
    @Override
    public void sayHello() {
        System.out.println("안녕하세요!");
    }
};
greeting.sayHello();
```

**익명 클래스 활용 시나리오**:
- 일회성 구현이 필요할 때
- 간단한 이벤트 핸들러
- 콜백 구현

**학습 포인트**:
- 내부 클래스의 종류와 특징
- 익명 클래스의 장단점
- 람다식과의 관계 (Java 8+)

**실행**: `AnonymousClassMain.java`

---

## 추상 클래스 vs 인터페이스

| 특징 | 추상 클래스 | 인터페이스 |
|-----|-----------|----------|
| 키워드 | `abstract class` | `interface` |
| 상속/구현 | 단일 상속 | 다중 구현 |
| 메서드 | 추상/일반 메서드 모두 가능 | 추상/디폴트/정적 메서드 |
| 필드 | 모든 종류 가능 | `public static final`만 |
| 생성자 | 가능 | 불가능 |
| 접근 제어자 | 모두 사용 가능 | `public`만 (암묵적) |
| 사용 목적 | 공통 기능 + 강제 구현 | 규약 정의 |

### 선택 기준

**추상 클래스를 사용하는 경우**:
- 관련된 클래스들 간 코드 공유
- `protected` 필드나 메서드 필요
- 상태(필드)를 가져야 함

**인터페이스를 사용하는 경우**:
- 서로 관련 없는 클래스들이 같은 동작
- 다중 타입 구현 필요
- 행동의 명세만 정의

## 권장 학습 순서

1. **ex01_abstraction** - 추상 클래스의 개념 이해
2. **ex02_interface/InterfaceMain** - 인터페이스 기본 학습
3. **ex02_interface/DefaultMethodMain** - 디폴트 메서드 학습
4. **ex02_interface/PolymorphismMain** - 다형성 활용
5. **ex03_nested** - 중첩 클래스와 익명 클래스

## 실행 방법

### IntelliJ에서 실행
각 예제의 `*Main.java` 파일을 열고 실행 버튼을 클릭합니다.

### 명령줄에서 실행
```bash
# 추상 클래스 예제
mvn exec:java -pl chap07 -Dexec.mainClass="com.chap07.ex01_abstraction.AbstractMain"

# 인터페이스 기본 예제
mvn exec:java -pl chap07 -Dexec.mainClass="com.chap07.ex02_interface.InterfaceMain"

# 디폴트 메서드 예제
mvn exec:java -pl chap07 -Dexec.mainClass="com.chap07.ex02_interface.DefaultMethodMain"

# 다형성 예제
mvn exec:java -pl chap07 -Dexec.mainClass="com.chap07.ex02_interface.PolymorphismMain"

# 익명 클래스 예제
mvn exec:java -pl chap07 -Dexec.mainClass="com.chap07.ex03_nested.AnonymousClassMain"
```

## 주요 개념 정리

### 추상화 (Abstraction)
복잡한 시스템으로부터 핵심적인 개념만 추출하여 단순화하는 것

**장점**:
- 복잡도 감소
- 코드 유지보수성 향상
- 변경에 유연한 설계

### 계약에 의한 설계 (Design by Contract)
인터페이스는 클래스가 구현해야 할 메서드의 계약을 정의

**장점**:
- 명확한 역할 정의
- 느슨한 결합
- 테스트 용이성

### SOLID 원칙과의 관계

- **OCP** (개방-폐쇄 원칙): 인터페이스로 확장에 열려있고 변경에 닫힌 설계
- **LSP** (리스코프 치환 원칙): 추상 타입으로 하위 타입 대체 가능
- **ISP** (인터페이스 분리 원칙): 작고 명확한 인터페이스 설계
- **DIP** (의존성 역전 원칙): 구체 클래스가 아닌 추상에 의존

## 연습 문제

1. **기본**: `Shape` 추상 클래스를 만들고 `Triangle`, `Square` 클래스를 구현해보세요.

2. **중급**: `Flyable`, `Swimmable` 인터페이스를 만들고 `Duck` 클래스가 둘 다 구현하도록 해보세요.

3. **고급**: 결제 시스템을 인터페이스로 설계하고 (`Payment`), 신용카드, 계좌이체, 간편결제를 구현해보세요.

## 디자인 패턴 연계

- **템플릿 메서드 패턴**: 추상 클래스 활용
- **전략 패턴**: 인터페이스 활용
- **팩토리 메서드 패턴**: 추상 클래스/인터페이스 활용
- **어댑터 패턴**: 인터페이스 활용

## 관련 개념

- **Chapter 06**: 상속의 기본 개념 (추상화의 기초)
- **Chapter 08**: 제네릭 인터페이스로 타입 안전성 확보
- **Chapter 10**: 컬렉션 인터페이스의 실전 활용

## 참고 자료

- [Oracle Java Tutorials - Abstract Classes](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)
- [Oracle Java Tutorials - Interfaces](https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html)
- [Oracle Java Tutorials - Default Methods](https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html)

---

**다음 단계**: Chapter 08에서 제네릭을 학습하여 타입 안전한 추상화를 경험하세요.
