# Chapter 06: 클래스와 상속

> Java 객체지향 프로그래밍의 핵심인 상속과 다형성을 학습합니다.

## 학습 목표

- 클래스의 기본 개념 이해
- 상속과 메서드 오버라이딩 활용
- 생성자와 접근 제어자를 통한 캡슐화
- final 키워드의 활용
- 타입 캐스팅의 원리
- 다형성의 원리와 활용
- 패키지 간 클래스 참조

## 패키지 구조

```
com.chap06/
├── ex01_class_basics/      # 클래스 기초
├── ex02_inheritance/       # 상속 개념
├── ex03_overriding/        # 메서드 오버라이딩
├── ex04_constructor/       # 생성자
├── ex05_access/            # 접근 제어자
├── ex06_final/             # final 키워드
├── ex07_typecast/          # 타입 캐스팅
├── ex08_polymorphism/      # 다형성
└── ex09_utils/             # import 실습
```

## 예제별 상세 내용

### ex01_class_basics - 클래스 기초
**파일**: `Prod.java`, `Vehicle.java`, `Box.java`

클래스의 기본 구조와 객체 생성을 학습합니다.

**학습 포인트**:
- 클래스 선언과 객체 생성
- 필드와 메서드 정의
- 생성자의 기본 개념

---

### ex02_inheritance - 상속 개념
**파일**: `Animal.java`, `NumTest.java`

상속의 기본 개념을 학습합니다.

```java
class Animal {
    void eat() {
        System.out.println("동물이 먹습니다.");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("멍멍!");
    }
}
```

**학습 포인트**:
- `extends` 키워드로 상속 구현
- 부모 클래스의 멤버 접근
- 상속 계층 구조

---

### ex03_overriding - 메서드 오버라이딩
**파일**: `Shape.java`

다양한 도형 클래스를 통해 메서드 오버라이딩을 학습합니다.

```
Shape (도형)
├── Circle (원)
│   ├── Ball (공)
│   ├── Cylinder (원기둥)
│   └── Cone (원뿔)
```

**학습 포인트**:
- 메서드 오버라이딩
- @Override 어노테이션
- 다단계 상속 구조

**주요 클래스**:
- `Shape`: 기본 도형 클래스
- `Circle`: 원 (반지름 기반)
- `Ball`: 구 (표면적 계산)
- `Cylinder`: 원기둥 (높이 추가)
- `Cone`: 원뿔 (높이 추가)

---

### ex04_constructor - 생성자
**파일**: `Calculator.java`, `InheritanceConstructorMain.java`

생성자의 개념과 상속 시 생성자 동작을 학습합니다.

**학습 포인트**:
- 생성자의 역할
- 기본 생성자와 매개변수 생성자
- 상속과 생성자 호출 순서
- `super()` 키워드

**실행**: `InheritanceConstructorMain.java`

---

### ex05_access - 접근 제어자
**파일**: `AccessModifierMain.java`, `Parent.java`, `Child.java`

접근 제어자를 통한 캡슐화를 학습합니다.

**접근 제어자 종류**:
- `public`: 모든 곳에서 접근 가능
- `protected`: 같은 패키지 + 상속받은 클래스
- `default`: 같은 패키지 내에서만
- `private`: 같은 클래스 내에서만

**학습 포인트**:
- 정보 은닉의 중요성
- getter/setter 메서드 패턴
- 캡슐화를 통한 데이터 보호

**실행**: `AccessModifierMain.java`

---

### ex06_final - final 키워드
**파일**: `FinalMain.java`

final 키워드의 다양한 활용법을 학습합니다.

```java
// final 변수 - 상수
final int MAX_VALUE = 100;

// final 메서드 - 오버라이딩 불가
public final void display() { }

// final 클래스 - 상속 불가
public final class Constants { }
```

**학습 포인트**:
- final 변수 (상수)
- final 메서드 (오버라이딩 방지)
- final 클래스 (상속 방지)

**실행**: `FinalMain.java`

---

### ex07_typecast - 타입 캐스팅
**파일**: `AutoTypeCastMain.java`, `MustTypeCastMain.java`, `TypeCheckMain.java`, `PersonAndStudent.java`

상속 관계에서의 형변환을 학습합니다.

**형변환 종류**:
```java
// 업캐스팅 (자동)
Parent p = new Child();

// 다운캐스팅 (명시적)
Child c = (Child) p;
```

**학습 포인트**:
- 자동 타입 캐스팅 (업캐스팅)
- 강제 타입 캐스팅 (다운캐스팅)
- `instanceof` 연산자
- 형변환 시 주의사항

**실행**: `AutoTypeCastMain.java`, `MustTypeCastMain.java`, `TypeCheckMain.java`

---

### ex08_polymorphism - 다형성
**파일**: `TypeCastPolymorphismMain.java`

다형성의 강력함을 체험합니다.

```java
Parent[] items = {new Child1(), new Child2()};
for (Parent item : items) {
    item.method();  // 각자의 구현 실행
}
```

**학습 포인트**:
- 하나의 타입, 여러 구현
- 메서드 오버라이딩과 동적 바인딩
- 유연한 코드 설계

**실행**: `TypeCastPolymorphismMain.java`

---

### ex09_utils - import 실습
**파일**: `CalculatorImportMain.java`

다른 패키지의 클래스를 import하여 사용하는 방법을 학습합니다.

```java
import com.chap06.ex04_constructor.Calculator;
```

**학습 포인트**:
- `import` 문 사용법
- 패키지 간 클래스 참조
- 접근 제어자와 패키지의 관계

**실행**: `CalculatorImportMain.java`

---

## 권장 학습 순서

1. **ex01_class_basics** - 클래스의 기본 문법 이해
2. **ex02_inheritance** - 상속 개념 학습
3. **ex03_overriding** - 메서드 오버라이딩 이해
4. **ex04_constructor** - 생성자와 상속의 관계 학습
5. **ex05_access** - 캡슐화와 접근 제어 학습
6. **ex06_final** - final 키워드 마스터
7. **ex07_typecast** - 타입 캐스팅 이해
8. **ex08_polymorphism** - 다형성의 힘 체험
9. **ex09_utils** - 패키지 구조 이해

## 실행 방법

### IntelliJ에서 실행
각 예제의 `*Main.java` 파일을 열고 실행 버튼을 클릭합니다.

### 명령줄에서 실행
```bash
# 생성자 예제 실행
mvn exec:java -pl chap06 -Dexec.mainClass="com.chap06.ex04_constructor.InheritanceConstructorMain"

# 접근 제어자 예제 실행
mvn exec:java -pl chap06 -Dexec.mainClass="com.chap06.ex05_access.AccessModifierMain"

# final 예제 실행
mvn exec:java -pl chap06 -Dexec.mainClass="com.chap06.ex06_final.FinalMain"

# 타입 캐스팅 예제 실행
mvn exec:java -pl chap06 -Dexec.mainClass="com.chap06.ex07_typecast.AutoTypeCastMain"

# 다형성 예제 실행
mvn exec:java -pl chap06 -Dexec.mainClass="com.chap06.ex08_polymorphism.TypeCastPolymorphismMain"

# import 예제 실행
mvn exec:java -pl chap06 -Dexec.mainClass="com.chap06.ex09_utils.CalculatorImportMain"
```

## 주요 개념 정리

### 상속 (Inheritance)
기존 클래스의 속성과 메서드를 새로운 클래스가 물려받는 것

**장점**:
- 코드 재사용성 향상
- 계층적 분류 가능
- 유지보수성 향상

### 다형성 (Polymorphism)
같은 타입이지만 실행 결과가 다양한 객체를 대입할 수 있는 성질

**장점**:
- 유연한 코드 작성
- 확장성 향상
- 인터페이스 통일

### 캡슐화 (Encapsulation)
객체의 속성과 메서드를 하나로 묶고 실제 구현 내용을 외부에 감추는 것

**장점**:
- 데이터 보호
- 정보 은닉
- 결합도 감소

## 연습 문제

1. **기본**: 학생(Student) 클래스를 만들고 대학생(UniversityStudent) 클래스로 상속해보세요.

2. **중급**: 도형 예제에 삼각형(Triangle) 클래스를 추가하고 면적 계산을 구현해보세요.

3. **고급**: 동물 계층 구조에 새(Bird), 물고기(Fish)를 추가하고, 이동 방식을 다르게 구현해보세요.

## 관련 개념

- **Chapter 07**: 추상 클래스와 인터페이스로 더 강력한 추상화 학습
- **Chapter 08**: 제네릭으로 타입 안전성 확보
- **Chapter 10**: 컬렉션과 다형성의 조합

## 참고 자료

- [Oracle Java Tutorials - Inheritance](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html)
- [Oracle Java Tutorials - Polymorphism](https://docs.oracle.com/javase/tutorial/java/IandI/polymorphism.html)

---

**다음 단계**: Chapter 07에서 추상 클래스와 인터페이스를 학습하여 더 강력한 추상화를 경험하세요.
