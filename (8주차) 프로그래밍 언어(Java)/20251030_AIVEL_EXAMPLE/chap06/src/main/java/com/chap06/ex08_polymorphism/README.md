# ex06_polymorphism - 다형성

> 다형성을 통한 유연하고 확장 가능한 코드 작성법을 학습합니다.

## 파일 구성

- `Animal.java` - 동물 인터페이스/부모 클래스
- `Dog.java` - 개 클래스
- `Cat.java` - 고양이 클래스
- `PolymorphismMain.java` - 실행 클래스

## 다형성이란?

**다형성(Polymorphism)**: 하나의 타입으로 여러 종류의 객체를 참조할 수 있는 능력

```java
Animal animal1 = new Dog();
Animal animal2 = new Cat();

animal1.sound();  // "멍멍"
animal2.sound();  // "야옹"
```

같은 `Animal` 타입이지만 실제 객체에 따라 다른 동작을 합니다.

## 다형성의 장점

### 1. 유연한 코드
```java
public void makeSound(Animal animal) {
    animal.sound();  // Dog, Cat 모두 처리 가능
}
```

### 2. 확장성
새로운 동물 추가 시 기존 코드 수정 불필요

```java
class Bird implements Animal {
    public void sound() {
        System.out.println("짹짹");
    }
}

// makeSound(new Bird());  // 그대로 동작
```

### 3. 배열과 컬렉션
```java
Animal[] animals = {
    new Dog(),
    new Cat(),
    new Bird()
};

for (Animal animal : animals) {
    animal.sound();  // 각자의 소리
}
```

## 다형성 구현 방법

### 1. 상속을 통한 다형성
```java
class Animal {
    void sound() { }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("멍멍");
    }
}
```

### 2. 인터페이스를 통한 다형성
```java
interface Animal {
    void sound();
}

class Dog implements Animal {
    public void sound() {
        System.out.println("멍멍");
    }
}
```

## 동적 바인딩

메서드 호출이 컴파일 시점이 아닌 **런타임 시점**에 결정됩니다.

```java
Animal animal = getRandomAnimal();  // Dog 또는 Cat
animal.sound();  // 실행 시점에 결정
```

## 실전 예제

### 동물원 시뮬레이션
```java
public class Zoo {
    private Animal[] animals;

    public void feedAll() {
        for (Animal animal : animals) {
            animal.eat();
        }
    }

    public void soundCheck() {
        for (Animal animal : animals) {
            animal.sound();
        }
    }
}
```

### 결제 시스템
```java
interface Payment {
    void pay(int amount);
}

class CreditCard implements Payment {
    public void pay(int amount) {
        System.out.println("신용카드 결제: " + amount);
    }
}

class Cash implements Payment {
    public void pay(int amount) {
        System.out.println("현금 결제: " + amount);
    }
}

// 다형성 활용
public void processPayment(Payment payment, int amount) {
    payment.pay(amount);  // 결제 수단에 관계없이 동작
}
```

## 실행 방법

```bash
mvn exec:java -pl chap06 -Dexec.mainClass="com.chap06.ex06_polymorphism.PolymorphismMain"
```

## OOP 원칙과의 관계

- **OCP (개방-폐쇄 원칙)**: 확장에는 열려있고 수정에는 닫혀있음
- **DIP (의존성 역전 원칙)**: 구체 클래스가 아닌 추상에 의존

## 정리

| 개념 | 설명 | 예시 |
|------|------|------|
| 다형성 | 하나의 타입, 여러 구현 | `Animal animal = new Dog();` |
| 동적 바인딩 | 런타임 메서드 결정 | `animal.sound()` → 실행 시 결정 |
| 유연성 | 새로운 타입 추가 용이 | `Bird` 추가해도 기존 코드 불변 |

## 다음 단계

**ex07_utils**에서 패키지 간 클래스 사용법을 학습하세요.
