# ex02_animals - 동물 계층 구조

> 실제 세계의 계층 구조를 Java 상속으로 표현합니다.

## 학습 목표

- 실용적인 상속 계층 설계
- 각 클래스의 고유한 행동 구현
- `super` 키워드를 통한 부모 메서드 호출
- 상속을 통한 코드 재사용

## 파일 구성

- `Animal.java` - 부모 클래스 (동물)
- `Dog.java` - 자식 클래스 (개)
- `Cat.java` - 자식 클래스 (고양이)
- `AnimalMain.java` - 실행 클래스

## 계층 구조

```
Animal (동물)
├── Dog (개)
└── Cat (고양이)
```

## 핵심 개념

### 공통 속성과 행동

모든 동물이 가지는 공통 특성을 `Animal` 클래스에 정의합니다.

```java
class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println(name + "이(가) 먹습니다.");
    }

    public void sleep() {
        System.out.println(name + "이(가) 잡니다.");
    }
}
```

### 특화된 행동

각 동물 고유의 행동을 자식 클래스에 구현합니다.

```java
class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);  // 부모 생성자 호출
    }

    public void bark() {
        System.out.println(name + ": 멍멍!");
    }

    @Override
    public void eat() {
        System.out.println(name + " 개가 사료를 먹습니다.");
    }
}

class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    public void meow() {
        System.out.println(name + ": 야옹~");
    }

    @Override
    public void eat() {
        System.out.println(name + " 고양이가 생선을 먹습니다.");
    }
}
```

## 주요 학습 포인트

### 1. 생성자와 super

자식 클래스의 생성자는 반드시 부모 생성자를 호출해야 합니다.

```java
public Dog(String name, int age) {
    super(name, age);  // 부모 생성자 명시적 호출
}
```

### 2. 메서드 오버라이딩

공통 메서드를 각 클래스의 특성에 맞게 재정의합니다.

```java
@Override
public void eat() {
    // 각 동물마다 다른 먹는 방식
}
```

### 3. 고유 메서드 추가

자식 클래스만의 독특한 행동을 추가합니다.

```java
public void bark() {  // Dog만의 메서드
    System.out.println("멍멍!");
}

public void meow() {  // Cat만의 메서드
    System.out.println("야옹~");
}
```

## 실행 방법

### IntelliJ에서 실행
1. `AnimalMain.java` 열기
2. 실행 버튼(▶) 클릭

### 명령줄에서 실행
```bash
mvn exec:java -pl chap06 -Dexec.mainClass="com.chap06.ex02_animals.AnimalMain"
```

## 예상 결과

```
바둑이: 멍멍!
바둑이 개가 사료를 먹습니다.
바둑이이(가) 잡니다.

나비: 야옹~
나비 고양이가 생선을 먹습니다.
나비이(가) 잡니다.
```

## 설계 원칙

### IS-A 관계
- Dog **IS-A** Animal (개는 동물이다)
- Cat **IS-A** Animal (고양이는 동물이다)

상속은 "~은 ~이다" 관계일 때 사용합니다.

### 단일 책임 원칙
- `Animal`: 모든 동물의 공통 행동
- `Dog`: 개 고유의 행동
- `Cat`: 고양이 고유의 행동

## 연습 문제

1. **기본**: `Bird` 클래스를 추가하고 `fly()` 메서드를 구현해보세요.

2. **중급**: `Animal` 클래스에 `move()` 메서드를 추가하고, 각 동물마다 다르게 오버라이딩해보세요.
   - Dog: "네 발로 뛰어갑니다."
   - Cat: "살금살금 걷습니다."
   - Bird: "날아갑니다."

3. **고급**: `Fish` 클래스를 추가하되, 물 속에서 사는 동물의 특성을 고려하여 설계해보세요.

## 실전 팁

### 언제 상속을 사용할까?

**사용하는 경우**:
- 명확한 IS-A 관계
- 코드 재사용이 필요한 경우
- 계층적 분류가 자연스러운 경우

**사용하지 않는 경우**:
- HAS-A 관계 (구성/위임 사용)
- 단순 코드 재사용만 목적일 때
- 관계가 불명확할 때

## 다음 단계

**ex03_shapes**에서 도형 계층 구조를 통해 다단계 상속을 학습하세요.
