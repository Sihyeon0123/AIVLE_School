# Chapter 01: 기본 자료형

> Java 프로그래밍의 시작, 기본 자료형을 학습합니다.

## 학습 목표

- Java 기본 자료형의 종류와 특징 이해
- 변수 선언과 초기화 방법 학습
- 각 자료형의 범위와 기본값 이해
- 리터럴과 자료형 변환의 기초

## 파일 구성

1. `Hello.java` - Java 프로그램의 시작
2. `BooleanValues.java` - 불린형 (true/false)
3. `CharValues.java` - 문자형 (char)
4. `IntegerValues.java` - 정수형 (byte, short, int, long)
5. `RealNumberValues.java` - 실수형 (float, double)

---

## 예제별 상세 내용

### 1. Hello.java - 첫 번째 Java 프로그램

```java
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, Java!");
    }
}
```

**주요 구성 요소**:
- `public class Hello`: 클래스 선언
- `public static void main(String[] args)`: 프로그램 진입점
- `System.out.println()`: 콘솔 출력

**실행**:
```bash
mvn exec:java -pl chap01 -Dexec.mainClass="com.chap01.Hello"
```

---

### 2. BooleanValues.java - 불린형

논리 값(참/거짓)을 표현하는 자료형입니다.

```java
public class BooleanValues {
    public static void main(String[] args) {
        boolean isTrue = true;
        boolean isFalse = false;

        System.out.println("isTrue: " + isTrue);
        System.out.println("isFalse: " + isFalse);
    }
}
```

**특징**:
- 값: `true` 또는 `false`
- 크기: 1비트 (구현에 따라 다름)
- 기본값: `false`
- 용도: 조건문, 논리 연산

**실행**:
```bash
mvn exec:java -pl chap01 -Dexec.mainClass="com.chap01.BooleanValues"
```

---

### 3. CharValues.java - 문자형

단일 문자를 표현하는 자료형입니다.

```java
public class CharValues {
    public static void main(String[] args) {
        char letter = 'A';
        char digit = '7';
        char symbol = '$';
        char unicode = '\u0041';  // 'A'의 유니코드

        System.out.println("letter: " + letter);
        System.out.println("digit: " + digit);
        System.out.println("symbol: " + symbol);
        System.out.println("unicode: " + unicode);
    }
}
```

**특징**:
- 크기: 2바이트 (16비트)
- 범위: 0 ~ 65,535 (유니코드)
- 표현: 작은따옴표 `'A'`
- 기본값: `'\u0000'` (null 문자)

**특수 문자**:
- `\n`: 줄바꿈
- `\t`: 탭
- `\\`: 백슬래시
- `\'`: 작은따옴표
- `\"`: 큰따옴표

**실행**:
```bash
mvn exec:java -pl chap01 -Dexec.mainClass="com.chap01.CharValues"
```

---

### 4. IntegerValues.java - 정수형

정수를 표현하는 자료형입니다.

```java
public class IntegerValues {
    public static void main(String[] args) {
        byte b = 127;
        short s = 32767;
        int i = 2147483647;
        long l = 9223372036854775807L;

        System.out.println("byte: " + b);
        System.out.println("short: " + s);
        System.out.println("int: " + i);
        System.out.println("long: " + l);
    }
}
```

**정수형 자료형**:

| 타입 | 크기 | 범위 | 기본값 |
|------|------|------|--------|
| `byte` | 1바이트 | -128 ~ 127 | 0 |
| `short` | 2바이트 | -32,768 ~ 32,767 | 0 |
| `int` | 4바이트 | -2,147,483,648 ~ 2,147,483,647 | 0 |
| `long` | 8바이트 | -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807 | 0L |

**리터럴 표기법**:
```java
int decimal = 100;       // 10진수
int hex = 0x64;          // 16진수 (100)
int octal = 0144;        // 8진수 (100)
int binary = 0b1100100;  // 2진수 (100)
long longValue = 100L;   // long 타입
```

**언더스코어 사용 (Java 7+)**:
```java
int million = 1_000_000;  // 가독성 향상
```

**실행**:
```bash
mvn exec:java -pl chap01 -Dexec.mainClass="com.chap01.IntegerValues"
```

---

### 5. RealNumberValues.java - 실수형

소수점을 포함하는 숫자를 표현하는 자료형입니다.

```java
public class RealNumberValues {
    public static void main(String[] args) {
        float f = 3.14f;
        double d = 3.141592653589793;

        System.out.println("float: " + f);
        System.out.println("double: " + d);

        // 과학적 표기법
        double scientific = 3.14e2;  // 3.14 × 10²
        System.out.println("scientific: " + scientific);
    }
}
```

**실수형 자료형**:

| 타입 | 크기 | 범위 | 정밀도 | 기본값 |
|------|------|------|--------|--------|
| `float` | 4바이트 | ±3.4E-38 ~ ±3.4E+38 | 7자리 | 0.0f |
| `double` | 8바이트 | ±1.7E-308 ~ ±1.7E+308 | 15자리 | 0.0d |

**리터럴 표기법**:
```java
float f1 = 3.14f;        // f 또는 F 접미사 필수
double d1 = 3.14;        // 기본값 (d 생략 가능)
double d2 = 3.14d;       // d 또는 D 접미사 (선택)
double scientific = 1.23e-4;  // 0.000123
```

**주의사항**:
- 부동소수점 연산은 근사값
- 정확한 계산이 필요하면 `BigDecimal` 사용
```java
System.out.println(0.1 + 0.2);  // 0.30000000000000004 (오차 발생)
```

**실행**:
```bash
mvn exec:java -pl chap01 -Dexec.mainClass="com.chap01.RealNumberValues"
```

---

## Java 기본 자료형 정리

### 기본형 (Primitive Type)

| 분류 | 타입 | 크기 | 범위/값 |
|------|------|------|---------|
| **논리형** | boolean | 1비트 | true, false |
| **문자형** | char | 2바이트 | 0 ~ 65,535 |
| **정수형** | byte | 1바이트 | -128 ~ 127 |
|  | short | 2바이트 | -32,768 ~ 32,767 |
|  | int | 4바이트 | -2¹⁵ ~ 2¹⁵-1 |
|  | long | 8바이트 | -2⁶³ ~ 2⁶³-1 |
| **실수형** | float | 4바이트 | ±3.4E±38 (7자리) |
|  | double | 8바이트 | ±1.7E±308 (15자리) |

### 참조형 (Reference Type)
- `String`: 문자열 (기본형 아님)
- 배열, 클래스, 인터페이스 등

---

## 자료형 변환

### 자동 형변환 (Widening Conversion)
작은 타입 → 큰 타입 (자동)

```java
byte → short → int → long → float → double
         char → int
```

```java
int i = 100;
long l = i;      // 자동 형변환
double d = i;    // 자동 형변환
```

### 명시적 형변환 (Narrowing Conversion)
큰 타입 → 작은 타입 (명시적 캐스팅 필요)

```java
double d = 3.14;
int i = (int) d;     // 3 (소수점 버림)
```

**주의**: 값의 손실 가능
```java
int i = 1000;
byte b = (byte) i;   // -24 (overflow)
```

---

## 변수 명명 규칙

### 필수 규칙
- 첫 글자: 문자, `_`, `$` (숫자 불가)
- 나머지: 문자, 숫자, `_`, `$`
- 대소문자 구분
- 예약어 사용 불가

### 권장 규칙 (Camel Case)
```java
int age;              // 변수: camelCase
final int MAX_VALUE = 100;  // 상수: UPPER_SNAKE_CASE
class MyClass { }     // 클래스: PascalCase
```

---

## 실습 예제

### 예제 1: 자료형 크기 확인
```java
System.out.println("byte: " + Byte.BYTES + " bytes");
System.out.println("int: " + Integer.BYTES + " bytes");
System.out.println("long: " + Long.BYTES + " bytes");
System.out.println("float: " + Float.BYTES + " bytes");
System.out.println("double: " + Double.BYTES + " bytes");
```

### 예제 2: 최소/최대값 확인
```java
System.out.println("int 최소값: " + Integer.MIN_VALUE);
System.out.println("int 최대값: " + Integer.MAX_VALUE);
System.out.println("double 최소값: " + Double.MIN_VALUE);
System.out.println("double 최대값: " + Double.MAX_VALUE);
```

---

## 연습 문제

1. **기본**: 자신의 이름, 나이, 키를 변수로 선언하고 출력해보세요.
2. **중급**: 섭씨 온도를 화씨로 변환하는 프로그램을 작성해보세요. (F = C × 9/5 + 32)
3. **고급**: 원의 반지름을 입력받아 넓이와 둘레를 계산해보세요.

---

## 다음 단계

**Chapter 02**에서 연산자를 학습하여 값을 계산하고 조작하는 방법을 배우세요.
