# ex07_utils - 유틸리티 클래스와 패키지 Import

> 다른 패키지의 클래스를 import하여 사용하는 방법을 학습합니다.

## 파일 구성

- `CalculatorImportMain.java` - 다른 패키지의 Calculator 클래스 사용 예제

## 핵심 개념

### import 문

다른 패키지의 클래스를 사용하려면 import 문이 필요합니다.

```java
package com.chap06.ex07_utils;

import com.chap06.ex04_access.Calculator;  // 다른 패키지의 클래스

public class CalculatorImportMain {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        // Calculator 사용
    }
}
```

## import의 종류

### 1. 특정 클래스 import
```java
import com.chap06.ex04_access.Calculator;
```

**장점**: 어떤 클래스를 사용하는지 명확

### 2. 패키지 전체 import
```java
import com.chap06.ex04_access.*;
```

**장점**: 같은 패키지의 여러 클래스 사용 시 편리
**단점**: 어떤 클래스를 사용하는지 불명확

### 3. static import
```java
import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

double area = PI * radius * radius;
double hypotenuse = sqrt(a * a + b * b);
```

## 패키지와 접근 제어

### public 클래스만 import 가능

```java
// Calculator.java (ex04_access 패키지)
public class Calculator {  // public이어야 다른 패키지에서 사용 가능
    // ...
}
```

### default 접근 제어자는 같은 패키지 내에서만
```java
class InternalHelper {  // default - 같은 패키지에서만
    // ...
}
```

## 실행 방법

```bash
mvn exec:java -pl chap06 -Dexec.mainClass="com.chap06.ex07_utils.CalculatorImportMain"
```

## 실전 활용

### 유틸리티 클래스 패턴
```java
public class StringUtils {
    // 인스턴스 생성 방지
    private StringUtils() { }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}

// 사용
import com.myproject.utils.StringUtils;

boolean empty = StringUtils.isEmpty(text);
```

### Java 표준 라이브러리 import
```java
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.time.LocalDate;
```

## import 생략 가능한 경우

### 1. java.lang 패키지
```java
// import 불필요
String str = new String();
System.out.println();
Math.sqrt(4);
```

### 2. 같은 패키지
같은 패키지 내의 클래스는 import 없이 사용 가능

### 3. 완전한 이름(Fully Qualified Name) 사용
```java
com.chap06.ex04_access.Calculator calc =
    new com.chap06.ex04_access.Calculator();
```

## 패키지 명명 규칙

```
com.company.project.module
└── 역순 도메인.프로젝트.모듈
```

**예시**:
- `com.chap06.ex01_basics` - Chapter 6, 예제 1
- `java.util` - Java 유틸리티
- `org.springframework.boot` - Spring Boot 프레임워크

## 정리

| 항목 | 설명 |
|------|------|
| **import** | 다른 패키지 클래스 사용 |
| **public** | 다른 패키지에서 접근 가능 |
| **default** | 같은 패키지에서만 접근 |
| **패키지** | 관련 클래스를 그룹화 |

## 다음 단계

Chapter 6 완료! **Chapter 07**에서 추상 클래스와 인터페이스를 학습하세요.
