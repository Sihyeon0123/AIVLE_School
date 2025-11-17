# Chapter 02: 연산자

> Java의 다양한 연산자를 학습하여 값을 계산하고 조작하는 방법을 익힙니다.

## 학습 목표

- 산술, 비교, 논리 연산자 이해
- 단항 연산자와 증감 연산자 활용
- 비트 연산자의 원리와 활용
- 연산자 우선순위와 결합 규칙 이해
- 형변환과 오버플로우/언더플로우 이해

## 파일 구성

1. `UnaryOperatorExample.java` - 단항 연산자
2. `CalculationExample.java` - 산술 연산자 기본
3. `CalculationDemo.java` - 산술 연산 응용
4. `ComparisonOperatorExample.java` - 비교 연산자
5. `LogicalOperationExample.java` - 논리 연산자
6. `ShiftOperationDemo.java` - 시프트 연산자
7. `XorEncryptionDemo.java` - XOR 암호화 예제
8. `PermissionChecker.java` - 비트 마스크 권한 체크
9. `TypeConversionExample.java` - 형변환
10. `OverflowExample.java` - 오버플로우
11. `UnderflowExample.java` - 언더플로우
12. `OperatorPrecedence.java` - 연산자 우선순위

---

## 연산자 분류

### 1. 단항 연산자
피연산자가 1개인 연산자

### 2. 이항 연산자
피연산자가 2개인 연산자 (대부분)

### 3. 삼항 연산자
피연산자가 3개인 연산자 (`? :`)

---

## 예제별 상세 내용

### 1. unaryOperatorExample.java - 단항 연산자

```java
public class unaryOperatorExample {
    public static void main(String[] args) {
        int a = 10;

        // 증감 연산자
        System.out.println("a++: " + (a++));  // 10 출력 후 증가
        System.out.println("a: " + a);        // 11
        System.out.println("++a: " + (++a));  // 증가 후 12 출력

        // 부호 연산자
        int b = -a;
        System.out.println("-a: " + b);       // -12

        // 논리 부정 연산자
        boolean flag = true;
        System.out.println("!flag: " + !flag); // false
    }
}
```

**단항 연산자 종류**:

| 연산자 | 설명 | 예시 |
|--------|------|------|
| `+` | 양수 (거의 사용 안 함) | `+a` |
| `-` | 음수 | `-a` |
| `++` | 1 증가 (전위/후위) | `++a`, `a++` |
| `--` | 1 감소 (전위/후위) | `--a`, `a--` |
| `!` | 논리 부정 | `!flag` |
| `~` | 비트 반전 | `~a` |

**증감 연산자 차이**:
```java
int a = 5;
int b = a++;  // b = 5, a = 6 (후위: 먼저 대입, 후 증가)
int c = ++a;  // c = 7, a = 7 (전위: 먼저 증가, 후 대입)
```

**실행**:
```bash
mvn exec:java -pl chap02 -Dexec.mainClass="com.chap02.UnaryOperatorExample"
```

---

### 2-3. CalculationExample.java, CalculationDemo.java - 산술 연산자

```java
public class CalculationExample {
    public static void main(String[] args) {
        int a = 10, b = 3;

        System.out.println("a + b = " + (a + b));  // 13
        System.out.println("a - b = " + (a - b));  // 7
        System.out.println("a * b = " + (a * b));  // 30
        System.out.println("a / b = " + (a / b));  // 3 (정수 나눗셈)
        System.out.println("a % b = " + (a % b));  // 1 (나머지)

        // 실수 나눗셈
        double result = (double) a / b;
        System.out.println("a / b = " + result);   // 3.333...
    }
}
```

**산술 연산자**:

| 연산자 | 설명 | 예시 | 결과 |
|--------|------|------|------|
| `+` | 덧셈 | `10 + 3` | 13 |
| `-` | 뺄셈 | `10 - 3` | 7 |
| `*` | 곱셈 | `10 * 3` | 30 |
| `/` | 나눗셈 | `10 / 3` | 3 (정수) |
| `%` | 나머지 | `10 % 3` | 1 |

**주의사항**:
- 정수 나눗셈: 소수점 버림
- 0으로 나누기: `ArithmeticException` 발생

---

### 4. ComparisonOperatorExample.java - 비교 연산자

```java
public class ComparisonOperatorExample {
    public static void main(String[] args) {
        int a = 10, b = 20;

        System.out.println("a == b: " + (a == b));  // false
        System.out.println("a != b: " + (a != b));  // true
        System.out.println("a > b: " + (a > b));    // false
        System.out.println("a < b: " + (a < b));    // true
        System.out.println("a >= b: " + (a >= b));  // false
        System.out.println("a <= b: " + (a <= b));  // true
    }
}
```

**비교 연산자**:

| 연산자 | 설명 | 결과 타입 |
|--------|------|----------|
| `==` | 같다 | boolean |
| `!=` | 다르다 | boolean |
| `>` | 크다 | boolean |
| `<` | 작다 | boolean |
| `>=` | 크거나 같다 | boolean |
| `<=` | 작거나 같다 | boolean |

**문자열 비교 주의**:
```java
String s1 = "hello";
String s2 = "hello";
System.out.println(s1 == s2);        // true (문자열 풀)
System.out.println(s1.equals(s2));   // true (권장)

String s3 = new String("hello");
System.out.println(s1 == s3);        // false (다른 객체)
System.out.println(s1.equals(s3));   // true (내용 같음)
```

---

### 5. LogicalOperationExample.java - 논리 연산자

```java
public class LogicalOperationExample {
    public static void main(String[] args) {
        boolean a = true, b = false;

        System.out.println("a && b: " + (a && b));  // false (AND)
        System.out.println("a || b: " + (a || b));  // true (OR)
        System.out.println("!a: " + !a);            // false (NOT)

        // 단락 평가 (Short-circuit)
        int x = 0;
        if (x != 0 && 10 / x > 1) {  // x != 0이 false이므로 10/x 평가 안 함
            System.out.println("실행되지 않음");
        }
    }
}
```

**논리 연산자**:

| 연산자 | 설명 | 단락 평가 |
|--------|------|-----------|
| `&&` | 논리 AND | ✅ |
| `||` | 논리 OR | ✅ |
| `!` | 논리 NOT | - |
| `&` | 비트 AND (논리로도 사용 가능) | ❌ |
| `|` | 비트 OR (논리로도 사용 가능) | ❌ |

**진리표**:

| A | B | A && B | A \|\| B | !A |
|---|---|--------|----------|-----|
| true | true | true | true | false |
| true | false | false | true | false |
| false | true | false | true | true |
| false | false | false | false | true |

---

### 6. ShiftOperationDemo.java - 시프트 연산자

```java
public class ShiftOperationDemo {
    public static void main(String[] args) {
        int a = 8;  // 1000 (2진수)

        System.out.println("a << 1: " + (a << 1));   // 16 (좌측 시프트)
        System.out.println("a >> 1: " + (a >> 1));   // 4 (우측 시프트)
        System.out.println("a >>> 1: " + (a >>> 1)); // 4 (부호 없는 우측 시프트)

        int negative = -8;
        System.out.println("negative >> 1: " + (negative >> 1));   // -4
        System.out.println("negative >>> 1: " + (negative >>> 1)); // 2147483644
    }
}
```

**시프트 연산자**:

| 연산자 | 설명 | 예시 |
|--------|------|------|
| `<<` | 좌측 시프트 (×2) | `8 << 1 = 16` |
| `>>` | 우측 시프트 (÷2, 부호 유지) | `8 >> 1 = 4` |
| `>>>` | 우측 시프트 (÷2, 부호 무시) | `-8 >>> 1 = 2147483644` |

**활용**:
- 빠른 곱셈/나눗셈 (2의 거듭제곱)
- 비트 조작

---

### 7. XorEncryptionDemo.java - XOR 암호화

```java
public class XorEncryptionDemo {
    public static void main(String[] args) {
        int data = 123;
        int key = 456;

        // 암호화
        int encrypted = data ^ key;
        System.out.println("암호화: " + encrypted);

        // 복호화 (같은 키로 XOR)
        int decrypted = encrypted ^ key;
        System.out.println("복호화: " + decrypted);  // 123
    }
}
```

**비트 연산자**:

| 연산자 | 설명 | 예시 |
|--------|------|------|
| `&` | AND | `5 & 3 = 1` |
| `|` | OR | `5 | 3 = 7` |
| `^` | XOR | `5 ^ 3 = 6` |
| `~` | NOT | `~5 = -6` |

**XOR 특성**:
- `a ^ a = 0`
- `a ^ 0 = a`
- `a ^ b ^ b = a` (암호화/복호화)

---

### 8. PermissionChecker.java - 비트 마스크

```java
public class PermissionChecker {
    // 권한 플래그
    static final int READ = 1 << 0;    // 0001
    static final int WRITE = 1 << 1;   // 0010
    static final int EXECUTE = 1 << 2; // 0100

    public static void main(String[] args) {
        // 권한 설정
        int permission = READ | WRITE;  // 0011

        // 권한 확인
        boolean canRead = (permission & READ) != 0;
        boolean canWrite = (permission & WRITE) != 0;
        boolean canExecute = (permission & EXECUTE) != 0;

        System.out.println("읽기 권한: " + canRead);      // true
        System.out.println("쓰기 권한: " + canWrite);    // true
        System.out.println("실행 권한: " + canExecute);  // false

        // 권한 추가
        permission |= EXECUTE;

        // 권한 제거
        permission &= ~WRITE;
    }
}
```

---

### 9. TypeConversionExample.java - 형변환

```java
public class TypeConversionExample {
    public static void main(String[] args) {
        // 자동 형변환 (Widening)
        int i = 100;
        long l = i;
        double d = i;

        // 명시적 형변환 (Narrowing)
        double d2 = 3.14;
        int i2 = (int) d2;  // 3 (소수점 버림)

        // 오버플로우 주의
        int bigInt = 1000;
        byte b = (byte) bigInt;  // -24 (오버플로우)
    }
}
```

---

### 10-11. OverflowExample.java, UnderflowExample.java

```java
public class OverflowExample {
    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
        System.out.println("max: " + max);           // 2147483647
        System.out.println("max + 1: " + (max + 1)); // -2147483648 (오버플로우)
    }
}
```

**오버플로우/언더플로우**:
- 표현 범위를 벗어나면 반대편 값으로 순환
- 주의: 예외가 발생하지 않음!

---

### 12. OperatorPrecedence.java - 연산자 우선순위

```java
public class OperatorPrecedence {
    public static void main(String[] args) {
        int result = 10 + 20 * 3;
        System.out.println(result);  // 70 (곱셈 먼저)

        int result2 = (10 + 20) * 3;
        System.out.println(result2); // 90 (괄호 먼저)
    }
}
```

**연산자 우선순위** (높음 → 낮음):

1. `()`, `[]`, `.`
2. `++`, `--`, `!`, `~`, `+`(단항), `-`(단항)
3. `*`, `/`, `%`
4. `+`, `-`
5. `<<`, `>>`, `>>>`
6. `<`, `<=`, `>`, `>=`
7. `==`, `!=`
8. `&`
9. `^`
10. `|`
11. `&&`
12. `||`
13. `? :`
14. `=`, `+=`, `-=`, `*=`, `/=`, `%=` 등

---

## 대입 연산자

### 복합 대입 연산자

| 연산자 | 의미 | 예시 |
|--------|------|------|
| `+=` | `a = a + b` | `a += 5` |
| `-=` | `a = a - b` | `a -= 3` |
| `*=` | `a = a * b` | `a *= 2` |
| `/=` | `a = a / b` | `a /= 4` |
| `%=` | `a = a % b` | `a %= 3` |
| `&=`, `|=`, `^=` | 비트 연산 대입 | `a &= 0xFF` |

---

## 삼항 연산자

```java
int a = 10, b = 20;
int max = (a > b) ? a : b;  // 20

// 중첩 가능 (가독성 주의)
int result = (a > b) ? a : (b > 0) ? b : 0;
```

**문법**: `조건 ? 참일_때_값 : 거짓일_때_값`

---

## 실전 팁

### 1. 부동소수점 비교
```java
double a = 0.1 + 0.2;
double b = 0.3;
System.out.println(a == b);  // false! (부동소수점 오차)

// 올바른 비교
double epsilon = 0.0001;
boolean equal = Math.abs(a - b) < epsilon;
```

### 2. 문자열 결합
```java
System.out.println("Result: " + 10 + 20);    // "Result: 1020"
System.out.println("Result: " + (10 + 20));  // "Result: 30"
```

### 3. 나눗셈 0 체크
```java
int result = (b != 0) ? a / b : 0;
```

---

## 연습 문제

1. **기본**: 두 정수의 사칙연산 결과를 모두 출력하는 프로그램 작성
2. **중급**: 윤년 판별 프로그램 (4의 배수이면서 100의 배수가 아니거나 400의 배수)
3. **고급**: 비트 연산을 사용하여 RGB 색상 값을 분리하고 합치는 프로그램 작성

---

## 다음 단계

**Chapter 03**에서 제어문을 학습하여 프로그램의 흐름을 제어하는 방법을 배우세요.
