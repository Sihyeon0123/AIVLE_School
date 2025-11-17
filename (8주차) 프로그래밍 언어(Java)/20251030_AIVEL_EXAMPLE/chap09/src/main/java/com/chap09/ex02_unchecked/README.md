# ex02_unchecked - Unchecked Exception

> 런타임에 발생하는 예외를 학습합니다.

## 파일 구성

1. `NullPointerExceptionExample.java` - Null 참조 오류
2. `ArrayIndexOutOfBoundsExceptionExample.java` - 배열 범위 초과
3. `ArithmeticExceptionExample.java` - 산술 연산 오류
4. `NumberFormatExceptionExample.java` - 숫자 변환 오류
5. `ClassCastExceptionExample.java` - 타입 변환 오류
6. `ClassCastExceptionCarClassExample.java` - 타입 변환 오류 (Car 예제)
7. `IllegalArgumentExceptionExample.java` - 잘못된 인자
8. `UserIllegalArgumentExceptionExample.java` - 사용자 정의 예외
9. `IllegalStateExceptionExample.java` - 잘못된 상태
10. `ThrowsExample.java` - 예외 전파
11. `CalculateAverage.java` - 종합 예제

## Unchecked Exception이란?

컴파일러가 체크하지 않는 예외로, **프로그래밍 오류**로 인해 발생합니다.

### 특징
- 런타임 시점에 발생
- 예외 처리가 선택적 (강제 아님)
- `RuntimeException`을 상속
- 대부분 예방 가능한 오류

### 대표적인 Unchecked Exception
- `NullPointerException`: null 참조
- `ArrayIndexOutOfBoundsException`: 배열 범위 초과
- `ArithmeticException`: 산술 오류
- `NumberFormatException`: 숫자 변환 실패
- `ClassCastException`: 타입 변환 실패
- `IllegalArgumentException`: 잘못된 인자
- `IllegalStateException`: 잘못된 상태

---

## 주요 예외 예제

### 1. NullPointerException - 가장 흔한 예외

```java
public class NullPointerExceptionExample {
    public static void main(String[] args) {
        try {
            String text = null;
            int length = text.length();  // NullPointerException!
        } catch (NullPointerException e) {
            System.out.println("NullPointerException 발생: " + e.getMessage());
        }
        System.out.println("프로그램 계속 실행됨.");
    }
}
```

**발생 원인**:
- null 객체의 메서드 호출
- null 객체의 필드 접근
- null 배열 접근

**예방 방법**:
```java
// 1. null 체크
if (text != null) {
    int length = text.length();
}

// 2. Optional 사용 (Java 8+)
Optional<String> optional = Optional.ofNullable(text);
optional.ifPresent(t -> System.out.println(t.length()));

// 3. Objects 유틸리티
String safeText = Objects.requireNonNull(text, "text는 null일 수 없습니다");
```

**실행**:
```bash
mvn exec:java -pl chap09 -Dexec.mainClass="com.chap09.ex02_unchecked.NullPointerExceptionExample"
```

---

### 2. ArrayIndexOutOfBoundsException - 배열 범위 초과

```java
try {
    int[] numbers = {1, 2, 3};
    System.out.println(numbers[5]);  // 인덱스 5는 존재하지 않음!
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("배열 범위 초과: " + e.getMessage());
}
```

**발생 원인**:
- 배열 크기보다 큰 인덱스 접근
- 음수 인덱스 사용

**예방 방법**:
```java
if (index >= 0 && index < array.length) {
    System.out.println(array[index]);
}
```

---

### 3. ArithmeticException - 산술 연산 오류

```java
try {
    int result = 10 / 0;  // 0으로 나누기!
} catch (ArithmeticException e) {
    System.out.println("산술 연산 오류: " + e.getMessage());
}
```

**발생 원인**:
- 정수를 0으로 나누기

**참고**: 부동소수점(double, float)은 예외가 발생하지 않고 `Infinity` 반환
```java
double result = 10.0 / 0.0;  // Infinity (예외 발생 안 함)
```

**예방 방법**:
```java
if (divisor != 0) {
    int result = dividend / divisor;
}
```

---

### 4. NumberFormatException - 숫자 변환 오류

```java
try {
    String text = "abc";
    int number = Integer.parseInt(text);  // 숫자가 아님!
} catch (NumberFormatException e) {
    System.out.println("숫자 변환 오류: " + e.getMessage());
}
```

**발생 원인**:
- 숫자가 아닌 문자열 파싱
- 잘못된 형식 (공백, 특수문자 등)

**예방 방법**:
```java
// 1. 정규식 검증
if (text.matches("\\d+")) {
    int number = Integer.parseInt(text);
}

// 2. try-catch로 안전하게 처리
try {
    return Integer.parseInt(text);
} catch (NumberFormatException e) {
    return defaultValue;
}
```

---

### 5. ClassCastException - 타입 변환 오류

```java
try {
    Object obj = "Hello";
    Integer num = (Integer) obj;  // String을 Integer로 변환 불가!
} catch (ClassCastException e) {
    System.out.println("타입 변환 오류: " + e.getMessage());
}
```

**발생 원인**:
- 호환되지 않는 타입으로 캐스팅
- 다운캐스팅 시 실제 타입 불일치

**예방 방법**:
```java
if (obj instanceof Integer) {
    Integer num = (Integer) obj;
}
```

---

### 6. IllegalArgumentException - 잘못된 인자

메서드에 부적절한 인자가 전달될 때 발생시킵니다.

```java
public class IllegalArgumentExceptionExample {
    public static void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("나이는 음수일 수 없습니다.");
        }
        System.out.println("나이: " + age);
    }

    public static void main(String[] args) {
        try {
            setAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}
```

**사용 시나리오**:
- 메서드 인자 유효성 검증
- 비즈니스 로직 검증
- Fail Fast 원칙

**실전 예제**:
```java
public void setPassword(String password) {
    if (password == null || password.length() < 8) {
        throw new IllegalArgumentException("비밀번호는 8자 이상이어야 합니다.");
    }
    this.password = password;
}
```

---

### 7. IllegalStateException - 잘못된 상태

객체의 상태가 메서드 호출에 적합하지 않을 때 발생시킵니다.

```java
public class IllegalStateExceptionExample {
    private boolean initialized = false;

    public void process() {
        if (!initialized) {
            throw new IllegalStateException("초기화되지 않았습니다.");
        }
        System.out.println("처리 중...");
    }

    public static void main(String[] args) {
        IllegalStateExceptionExample example = new IllegalStateExceptionExample();
        try {
            example.process();
        } catch (IllegalStateException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}
```

**사용 시나리오**:
- 객체 생명주기 관리
- 순서가 중요한 메서드 호출
- 상태 머신 구현

**실전 예제**:
```java
public class Connection {
    private boolean connected = false;

    public void sendData(String data) {
        if (!connected) {
            throw new IllegalStateException("연결되지 않았습니다.");
        }
        // 데이터 전송
    }
}
```

---

### 8. ThrowsExample.java - 예외 전파

```java
public class ThrowsExample {
    public static void method1() throws Exception {
        method2();
    }

    public static void method2() throws Exception {
        throw new Exception("예외 발생!");
    }

    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e) {
            System.out.println("예외 처리: " + e.getMessage());
        }
    }
}
```

**throw vs throws**:

| 키워드 | 위치 | 용도 |
|--------|------|------|
| `throw` | 메서드 내부 | 예외를 실제로 발생시킴 |
| `throws` | 메서드 시그니처 | 예외를 호출자에게 전파 |

---

## Checked vs Unchecked 비교

| 항목 | Checked Exception | Unchecked Exception |
|------|-------------------|---------------------|
| 상속 | `Exception` | `RuntimeException` |
| 컴파일 체크 | ✅ 필수 | ❌ 선택 |
| 처리 강제 | try-catch 또는 throws | 선택적 |
| 발생 시점 | 컴파일 타임 확인 | 런타임 발생 |
| 발생 원인 | 외부 요인 | 프로그래밍 오류 |
| 복구 가능성 | 보통 가능 | 보통 불가능 |
| 예시 | IOException, SQLException | NullPointerException, IllegalArgumentException |

## 예외 처리 베스트 프랙티스

### 1. 조기 반환 (Fail Fast)
```java
public void setAge(int age) {
    if (age < 0) {
        throw new IllegalArgumentException("나이는 음수일 수 없습니다.");
    }
    if (age > 150) {
        throw new IllegalArgumentException("유효하지 않은 나이입니다.");
    }
    this.age = age;
}
```

### 2. 예외 무시하지 않기
```java
// 나쁜 예
try {
    // ...
} catch (Exception e) { }

// 좋은 예
try {
    // ...
} catch (Exception e) {
    logger.error("오류 발생", e);
}
```

### 3. 구체적인 예외 사용
```java
// 나쁜 예
throw new Exception("오류");

// 좋은 예
throw new IllegalArgumentException("나이는 0보다 커야 합니다: " + age);
```

### 4. 의미있는 예외 메시지
```java
throw new IllegalArgumentException(
    String.format("유효하지 않은 이메일 형식: %s", email)
);
```

## 언제 어떤 예외를 사용할까?

### IllegalArgumentException
- 메서드 파라미터가 유효하지 않을 때
- 예: 음수 금액, 빈 문자열, null이 허용되지 않는 경우

### IllegalStateException
- 객체 상태가 메서드 호출에 적합하지 않을 때
- 예: 초기화되지 않음, 이미 닫힌 연결, 잘못된 상태 전이

### NullPointerException
- 일반적으로 직접 throw하지 않음
- 대신 `Objects.requireNonNull()` 사용 권장

### UnsupportedOperationException
- 지원하지 않는 연산일 때
- 예: 읽기 전용 컬렉션에 add() 호출

## 실행 방법

```bash
# NullPointerException
mvn exec:java -pl chap09 -Dexec.mainClass="com.chap09.ex02_unchecked.NullPointerExceptionExample"

# IllegalArgumentException
mvn exec:java -pl chap09 -Dexec.mainClass="com.chap09.ex02_unchecked.IllegalArgumentExceptionExample"

# 예외 전파
mvn exec:java -pl chap09 -Dexec.mainClass="com.chap09.ex02_unchecked.ThrowsExample"
```

## 정리

- **Unchecked Exception**: 프로그래밍 오류로 인한 예외
- **예방 중심**: 코드로 예방 가능한 오류
- **선택적 처리**: try-catch가 강제되지 않음
- **RuntimeException 상속**: 모든 Unchecked Exception의 공통점

## 다음 단계

Chapter 9 완료! **Chapter 10**에서 컬렉션 프레임워크를 학습하세요.
