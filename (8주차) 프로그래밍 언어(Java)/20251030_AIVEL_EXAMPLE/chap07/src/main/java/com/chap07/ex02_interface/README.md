# ex02_interface - 인터페이스

> 인터페이스를 통한 규약 정의와 다중 구현을 학습합니다.

## 파일 구성

- `InterfaceMain.java` - 기본 인터페이스 예제
- `DefaultMethodMain.java` - 디폴트 메서드 예제
- `PolymorphismMain.java` - 인터페이스와 다형성

## 인터페이스란?

클래스가 구현해야 할 메서드의 **규약(계약)**을 정의합니다.

```java
interface Drawable {
    void draw();  // public abstract 생략 가능
}

class Circle implements Drawable {
    @Override
    public void draw() {
        System.out.println("원 그리기");
    }
}
```

## 인터페이스 특징

### 1. 모든 메서드는 public abstract
```java
interface MyInterface {
    void method1();  // public abstract void method1();
    int method2();   // public abstract int method2();
}
```

### 2. 모든 필드는 public static final
```java
interface Constants {
    int MAX_VALUE = 100;  // public static final int MAX_VALUE = 100;
}
```

### 3. 다중 구현 가능
```java
interface Drawable {
    void draw();
}

interface Colorable {
    void setColor(String color);
}

class Shape implements Drawable, Colorable {
    public void draw() { }
    public void setColor(String color) { }
}
```

## 추상 클래스 vs 인터페이스

| 특징 | 추상 클래스 | 인터페이스 |
|------|------------|-----------|
| 키워드 | `abstract class` | `interface` |
| 다중 상속/구현 | 단일 상속 | 다중 구현 |
| 생성자 | 가능 | 불가능 |
| 필드 | 모든 종류 | `public static final`만 |
| 메서드 구현 | 가능 | 디폴트/정적만 가능 |
| 사용 목적 | 공통 기능 + 강제 구현 | 규약 정의 |

## 예제 1: InterfaceMain.java - 기본 인터페이스

### 인터페이스 정의
```java
interface Drawable {
    void draw();
}

interface Colorable {
    void setColor(String color);
}
```

### 다중 인터페이스 구현
```java
class Shape implements Drawable, Colorable {
    private String color;

    @Override
    public void draw() {
        System.out.println(color + " 도형을 그립니다.");
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }
}
```

## 예제 2: DefaultMethodMain.java - 디폴트 메서드

Java 8부터 인터페이스에 구현된 메서드를 추가할 수 있습니다.

```java
interface A {
    void method1();  // 추상 메서드 (필수 구현)

    default void method2() {  // 디폴트 메서드 (선택적 구현)
        System.out.println("디폴트 메서드");
    }
}

class C1 implements A {
    @Override
    public void method1() {
        System.out.println("C1에서 method1() 구현");
    }
    // method2()는 구현하지 않아도 됨
}

class D1 implements A {
    @Override
    public void method1() {
        System.out.println("D1에서 method1() 구현");
    }

    @Override
    public void method2() {
        System.out.println("D1에서 method2()를 오버라이드함");
    }
}
```

### 디폴트 메서드의 장점

1. **하위 호환성**: 기존 구현체를 깨지 않고 인터페이스에 메서드 추가
2. **공통 기능**: 여러 구현체에서 공유하는 기본 기능 제공
3. **선택적 구현**: 필요한 경우에만 오버라이드

## 예제 3: PolymorphismMain.java - 다형성

인터페이스를 활용한 다형성 구현입니다.

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
    animal.sound();
}
```

## 실전 예제

### 1. 전략 패턴 (Strategy Pattern)
```java
interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("신용카드 결제: " + amount);
    }
}

class CashPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("현금 결제: " + amount);
    }
}

class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}
```

### 2. 의존성 역전 (DIP)
```java
// 고수준 모듈이 저수준 모듈에 의존하지 않고 추상화에 의존
interface MessageSender {
    void send(String message);
}

class EmailSender implements MessageSender {
    public void send(String message) {
        System.out.println("이메일 전송: " + message);
    }
}

class SmsSender implements MessageSender {
    public void send(String message) {
        System.out.println("SMS 전송: " + message);
    }
}

class NotificationService {
    private MessageSender sender;

    NotificationService(MessageSender sender) {
        this.sender = sender;  // 구체 클래스가 아닌 인터페이스에 의존
    }

    void notify(String message) {
        sender.send(message);
    }
}
```

## 정적 메서드 (Java 8+)

인터페이스에 유틸리티 메서드를 정의할 수 있습니다.

```java
interface MathOperations {
    static int add(int a, int b) {
        return a + b;
    }

    static int multiply(int a, int b) {
        return a * b;
    }
}

// 사용
int sum = MathOperations.add(5, 3);
```

## 언제 인터페이스를 사용할까?

### 사용하는 경우
- 서로 관련 없는 클래스들이 **같은 동작**을 수행해야 할 때
- **다중 타입** 구현이 필요할 때
- **규약(계약)**만 정의하고 구현은 자유롭게 할 때

### 예시
- `List`, `Set`, `Map` (Java 컬렉션)
- `Runnable`, `Callable` (Java 동시성)
- `Serializable`, `Cloneable` (마커 인터페이스)

## 실행 방법

```bash
# 기본 인터페이스
mvn exec:java -pl chap07 -Dexec.mainClass="com.chap07.ex02_interface.InterfaceMain"

# 디폴트 메서드
mvn exec:java -pl chap07 -Dexec.mainClass="com.chap07.ex02_interface.DefaultMethodMain"

# 다형성
mvn exec:java -pl chap07 -Dexec.mainClass="com.chap07.ex02_interface.PolymorphismMain"
```

## 정리

- **인터페이스**: 메서드의 규약(계약) 정의
- **다중 구현**: 하나의 클래스가 여러 인터페이스 구현 가능
- **디폴트 메서드**: Java 8부터 인터페이스에 구현 가능
- **목적**: 행동의 명세, 느슨한 결합, 다형성

## 다음 단계

**ex03_nested**에서 중첩 클래스와 익명 클래스를 학습하세요.
