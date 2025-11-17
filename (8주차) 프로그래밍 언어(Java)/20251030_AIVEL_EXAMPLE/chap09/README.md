# Chapter 09: 예외 처리

> 예외 처리를 통해 안정적이고 견고한 프로그램을 작성하는 방법을 학습합니다.

## 학습 목표

- 예외의 개념과 필요성 이해
- Checked Exception과 Unchecked Exception 구분
- try-catch-finally 구문 활용
- 예외 전파와 throws 키워드
- 사용자 정의 예외 생성
- 예외 처리 베스트 프랙티스

## 패키지 구조

```
com.chap09/
├── ex01_checked/          # Checked Exception
│   ├── IOExceptionExample.java
│   └── MalformedURLExceptionExample.java
└── ex02_unchecked/        # Unchecked Exception
    ├── NullPointerExceptionExample.java
    ├── ArrayIndexOutOfBoundsExceptionExample.java
    ├── ArithmeticExceptionExample.java
    ├── NumberFormatExceptionExample.java
    ├── ClassCastExceptionExample.java
    ├── ClassCastExceptionCarClassExample.java
    ├── IllegalArgumentExceptionExample.java
    ├── UserIllegalArgumentExceptionExample.java
    ├── IllegalStateExceptionExample.java
    ├── ThrowsExample.java
    └── CalculateAverage.java
```

## 예외란?

예외(Exception)는 프로그램 실행 중 발생하는 예상치 못한 상황으로, 적절히 처리하지 않으면 프로그램이 비정상 종료됩니다.

### 예외 계층 구조

```
Throwable
├── Error (시스템 오류 - 처리 불가)
│   ├── OutOfMemoryError
│   └── StackOverflowError
└── Exception (예외 - 처리 가능)
    ├── IOException (Checked)
    ├── SQLException (Checked)
    └── RuntimeException (Unchecked)
        ├── NullPointerException
        ├── ArrayIndexOutOfBoundsException
        └── IllegalArgumentException
```

## Checked vs Unchecked Exception

### Checked Exception (확인된 예외)
- 컴파일 시점에 체크되는 예외
- 반드시 예외 처리 코드 작성 필요
- 주로 외부 리소스 처리 시 발생

### Unchecked Exception (미확인 예외)
- 런타임 시점에 발생하는 예외
- 예외 처리가 선택적
- 주로 프로그래밍 오류로 인해 발생

| 구분 | Checked Exception | Unchecked Exception |
|-----|-------------------|---------------------|
| 확인 시점 | 컴파일 타임 | 런타임 |
| 처리 강제 | 필수 | 선택 |
| 상속 | Exception | RuntimeException |
| 예시 | IOException, SQLException | NullPointerException, IllegalArgumentException |
| 발생 원인 | 외부 요인 | 프로그래밍 오류 |

---

## ex01_checked - Checked Exception

컴파일 시점에 체크되는 예외를 학습합니다.

### IOExceptionExample.java - 파일 입출력 예외

파일을 읽을 때 발생할 수 있는 예외를 처리합니다.

```java
public class IOExceptionExample {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("exemple.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾는데 오류가 발생했습니다: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("파일을 읽는 도중 오류가 발생했습니다: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("파일을 닫는 도중 오류가 발생했습니다: " + e.getMessage());
            }
        }
    }
}
```

**발생 가능한 예외**:
- `FileNotFoundException`: 파일을 찾을 수 없음
- `IOException`: 파일 읽기/쓰기 중 오류

**학습 포인트**:
- 다중 catch 블록 사용
- finally 블록에서 리소스 정리
- 예외 계층 구조 (FileNotFoundException은 IOException의 하위)

**실행**: `IOExceptionExample.java`

---

### MalformedURLExceptionExample.java - URL 형식 오류

잘못된 URL 형식으로 인한 예외를 처리합니다.

```java
import java.net.MalformedURLException;
import java.net.URL;

public class MalformedURLExceptionExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("htp://invalid-url");  // 잘못된 프로토콜
        } catch (MalformedURLException e) {
            System.out.println("잘못된 URL 형식: " + e.getMessage());
        }
    }
}
```

**발생 원인**:
- 잘못된 프로토콜 (http 대신 htp)
- 잘못된 URL 구조

**학습 포인트**:
- URL 생성 시 예외 처리 필요
- 외부 리소스 접근 시 예외 처리

**실행**: `MalformedURLExceptionExample.java`

---

## ex02_unchecked - Unchecked Exception

런타임에 발생하는 예외들을 학습합니다.

### NullPointerExceptionExample.java - Null 참조 오류

가장 흔한 런타임 예외인 NullPointerException을 다룹니다.

```java
public class NullPointerExceptionExample {
    public static void main(String[] args) {
        try {
            String text = null;
            int length = text.length();  // NullPointerException 발생
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

**예방 방법**:
- null 체크 수행
- Optional 사용 (Java 8+)
- 객체 초기화 확인

**실행**: `NullPointerExceptionExample.java`

---

### ArrayIndexOutOfBoundsExceptionExample.java - 배열 범위 초과

배열의 인덱스 범위를 벗어날 때 발생하는 예외입니다.

```java
public class ArrayIndexOutOfBoundsExceptionExample {
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]);  // 인덱스 5는 존재하지 않음
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열 범위 초과: " + e.getMessage());
        }
    }
}
```

**발생 원인**:
- 배열 크기보다 큰 인덱스 접근
- 음수 인덱스 사용

**예방 방법**:
- 배열 길이 확인 (`array.length`)
- 반복문 범위 검증

**실행**: `ArrayIndexOutOfBoundsExceptionExample.java`

---

### ArithmeticExceptionExample.java - 산술 연산 오류

0으로 나누기 등 잘못된 산술 연산 시 발생합니다.

```java
public class ArithmeticExceptionExample {
    public static void main(String[] args) {
        try {
            int result = 10 / 0;  // 0으로 나누기
        } catch (ArithmeticException e) {
            System.out.println("산술 연산 오류: " + e.getMessage());
        }
    }
}
```

**발생 원인**:
- 정수를 0으로 나누기
- 잘못된 수학 연산

**학습 포인트**:
- 나눗셈 전 분모 검증
- 부동소수점 연산의 차이 (double은 Infinity 반환)

**실행**: `ArithmeticExceptionExample.java`

---

### NumberFormatExceptionExample.java - 숫자 변환 오류

문자열을 숫자로 변환할 때 발생하는 예외입니다.

```java
public class NumberFormatExceptionExample {
    public static void main(String[] args) {
        try {
            String text = "abc";
            int number = Integer.parseInt(text);  // 숫자가 아닌 문자열
        } catch (NumberFormatException e) {
            System.out.println("숫자 변환 오류: " + e.getMessage());
        }
    }
}
```

**발생 원인**:
- 숫자가 아닌 문자열 파싱
- 잘못된 형식의 숫자 문자열

**예방 방법**:
- 정규식으로 숫자 형식 검증
- try-catch로 안전하게 처리

**실행**: `NumberFormatExceptionExample.java`

---

### ClassCastExceptionExample.java - 타입 변환 오류

잘못된 타입 캐스팅 시 발생하는 예외입니다.

```java
public class ClassCastExceptionExample {
    public static void main(String[] args) {
        try {
            Object obj = "Hello";
            Integer num = (Integer) obj;  // String을 Integer로 변환 불가
        } catch (ClassCastException e) {
            System.out.println("타입 변환 오류: " + e.getMessage());
        }
    }
}
```

**발생 원인**:
- 호환되지 않는 타입으로 캐스팅
- 다운캐스팅 시 실제 타입 불일치

**예방 방법**:
- `instanceof` 연산자로 타입 확인
- 제네릭 사용으로 타입 안전성 확보

**실행**: `ClassCastExceptionExample.java`, `ClassCastExceptionCarClassExample.java`

---

### IllegalArgumentExceptionExample.java - 잘못된 인자

메서드에 잘못된 인자가 전달될 때 발생합니다.

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

**학습 포인트**:
- `throw` 키워드로 예외 발생
- 의미있는 예외 메시지 작성

**실행**: `IllegalArgumentExceptionExample.java`, `UserIllegalArgumentExceptionExample.java`

---

### IllegalStateExceptionExample.java - 잘못된 상태

객체의 상태가 메서드 호출에 적합하지 않을 때 발생합니다.

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
- 객체 상태 검증
- 순서가 중요한 메서드 호출

**실행**: `IllegalStateExceptionExample.java`

---

### ThrowsExample.java - 예외 전파

메서드에서 예외를 호출자에게 전파하는 방법을 학습합니다.

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

**throws vs throw**:
- `throws`: 메서드 선언부에 예외 명시 (전파)
- `throw`: 실제 예외 발생

**학습 포인트**:
- 예외 전파 메커니즘
- 메서드 시그니처에 예외 선언

**실행**: `ThrowsExample.java`

---

### CalculateAverage.java - 종합 예제

여러 예외를 처리하는 종합 예제입니다.

**실행**: `CalculateAverage.java`

---

## 예외 처리 구문

### try-catch-finally
```java
try {
    // 예외가 발생할 수 있는 코드
} catch (ExceptionType1 e) {
    // ExceptionType1 처리
} catch (ExceptionType2 e) {
    // ExceptionType2 처리
} finally {
    // 항상 실행되는 코드 (리소스 정리)
}
```

### try-with-resources (Java 7+)
```java
try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
    String line = reader.readLine();
} catch (IOException e) {
    e.printStackTrace();
}
// reader.close()가 자동으로 호출됨
```

### 다중 catch (Java 7+)
```java
try {
    // 코드
} catch (IOException | SQLException e) {
    // 두 예외를 동시에 처리
    e.printStackTrace();
}
```

## 예외 처리 베스트 프랙티스

### 1. 구체적인 예외 처리
```java
// 나쁜 예
try {
    // ...
} catch (Exception e) {  // 너무 광범위
}

// 좋은 예
try {
    // ...
} catch (FileNotFoundException e) {  // 구체적
    // 파일 없음 처리
} catch (IOException e) {
    // IO 오류 처리
}
```

### 2. 예외 무시하지 않기
```java
// 나쁜 예
try {
    // ...
} catch (Exception e) {
    // 빈 catch 블록 - 절대 금지!
}

// 좋은 예
try {
    // ...
} catch (Exception e) {
    logger.error("오류 발생", e);
    // 또는 재처리, 복구 시도
}
```

### 3. 의미있는 예외 메시지
```java
// 나쁜 예
throw new IllegalArgumentException("오류");

// 좋은 예
throw new IllegalArgumentException(
    "나이는 0보다 커야 합니다. 입력값: " + age
);
```

### 4. 조기 반환 (Fail Fast)
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

### 5. 리소스 정리
```java
// try-with-resources 사용 (권장)
try (FileInputStream fis = new FileInputStream("file.txt")) {
    // 사용
} catch (IOException e) {
    // 예외 처리
}
// fis.close() 자동 호출
```

## 사용자 정의 예외

```java
// 사용자 정의 Checked Exception
public class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

// 사용자 정의 Unchecked Exception
public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String message) {
        super(message);
    }
}
```

## 권장 학습 순서

1. **ex01_checked/IOExceptionExample** - Checked Exception 이해
2. **ex01_checked/MalformedURLExceptionExample** - URL 예외 처리
3. **ex02_unchecked/NullPointerExceptionExample** - 가장 흔한 예외
4. **ex02_unchecked/ArrayIndexOutOfBoundsExceptionExample** - 배열 예외
5. **ex02_unchecked/ArithmeticExceptionExample** - 산술 예외
6. **ex02_unchecked/NumberFormatExceptionExample** - 변환 예외
7. **ex02_unchecked/ClassCastExceptionExample** - 캐스팅 예외
8. **ex02_unchecked/IllegalArgumentExceptionExample** - 인자 검증
9. **ex02_unchecked/ThrowsExample** - 예외 전파
10. **ex02_unchecked/CalculateAverage** - 종합 예제

## 실행 방법

### IntelliJ에서 실행
각 예제의 `.java` 파일을 열고 실행 버튼을 클릭합니다.

### 명령줄에서 실행
```bash
# Checked Exception 예제
mvn exec:java -pl chap09 -Dexec.mainClass="com.chap09.ex01_checked.IOExceptionExample"

# NullPointerException 예제
mvn exec:java -pl chap09 -Dexec.mainClass="com.chap09.ex02_unchecked.NullPointerExceptionExample"

# 예외 전파 예제
mvn exec:java -pl chap09 -Dexec.mainClass="com.chap09.ex02_unchecked.ThrowsExample"
```

## 관련 개념

- **Chapter 06**: 상속 (예외 클래스도 상속 구조)
- **Chapter 10**: 컬렉션과 예외 처리

## 참고 자료

- [Oracle Java Tutorials - Exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/)
- [Effective Java - Item 69~77 (Exceptions)](https://www.oreilly.com/library/view/effective-java/9780134686097/)

---

**다음 단계**: Chapter 10에서 컬렉션 프레임워크를 학습하여 효율적인 데이터 관리를 경험하세요.
