# Chapter 03: 제어문

> if, switch 문을 사용하여 프로그램의 흐름을 제어하는 방법을 학습합니다.

## 학습 목표

- if-else 문으로 조건에 따른 분기 처리
- switch 문으로 다중 선택 구조 구현
- String 비교와 처리 방법 이해
- 배열의 기초와 활용
- Enum 타입의 사용법 이해

## 파일 구성 (18개)

### 문자열 처리 (6개)
1. `StringExample.java` - 문자열 기본
2. `StringCompareExample.java` - 문자열 비교 (==  vs equals)
3. `StringComparisonDemo.java` - 문자열 비교 심화
4. `StringMethodDemo.java` - 문자열 메서드
5. `StringManipulationDemo.java` - 문자열 조작
6. `StringJoinDemo.java` - 문자열 결합

### 배열 처리 (9개)
7. `ArrayCreationDemo.java` - 배열 생성
8. `ArrayAccessDemo.java` - 배열 접근
9. `ArrayIterationDemo.java` - 배열 반복
10. `BallArrayDemo.java` - 객체 배열
11. `DynamicArrayDemo.java` - 동적 배열
12. `MultiDimensionalArrayDemo.java` - 다차원 배열
13. `ScoreWithoutArray.java` - 배열 없이 점수 처리
14. `ScoreWithArray.java` - 배열로 점수 처리
15. `VarargsExample.java` - 가변 인자

### Enum & 기타 (3개)
16. `EnumExample.java` - Enum 기본
17. `EnumValues.java` - Enum 값 순회
18. `MainArgumentsExample.java` - main 메서드 인자

---

## 주요 개념

### 1. if-else 문

```java
int score = 85;

if (score >= 90) {
    System.out.println("A");
} else if (score >= 80) {
    System.out.println("B");
} else if (score >= 70) {
    System.out.println("C");
} else {
    System.out.println("F");
}
```

**특징**:
- 조건은 boolean 타입
- 중괄호 `{}` 생략 가능 (단일 문장)
- 중첩 가능

---

### 2. switch 문

```java
int day = 3;

switch (day) {
    case 1:
        System.out.println("월요일");
        break;
    case 2:
        System.out.println("화요일");
        break;
    case 3:
        System.out.println("수요일");
        break;
    default:
        System.out.println("기타");
}
```

**특징**:
- `break` 없으면 fall-through
- Java 7+: String 사용 가능
- Java 12+: switch 표현식 지원

---

### 3. 문자열 비교

#### StringCompareExample.java - == vs equals

```java
String s1 = "hello";
String s2 = "hello";
String s3 = new String("hello");

System.out.println(s1 == s2);        // true (문자열 풀)
System.out.println(s1 == s3);        // false (다른 객체)
System.out.println(s1.equals(s3));   // true (내용 같음)
```

**규칙**:
- `==`: 참조(주소) 비교
- `equals()`: 내용 비교 (권장)

#### 주요 문자열 메서드

| 메서드 | 설명 | 예시 |
|--------|------|------|
| `length()` | 길이 | `"hello".length()` → 5 |
| `charAt(i)` | i번째 문자 | `"hello".charAt(1)` → 'e' |
| `substring(start, end)` | 부분 문자열 | `"hello".substring(1, 4)` → "ell" |
| `indexOf(str)` | 문자열 찾기 | `"hello".indexOf("ll")` → 2 |
| `replace(old, new)` | 치환 | `"hello".replace("l", "L")` → "heLLo" |
| `toUpperCase()` | 대문자 | `"hello".toUpperCase()` → "HELLO" |
| `toLowerCase()` | 소문자 | `"HELLO".toLowerCase()` → "hello" |
| `trim()` | 공백 제거 | `" hi ".trim()` → "hi" |
| `split(regex)` | 분할 | `"a,b,c".split(",")` → ["a", "b", "c"] |

---

### 4. 배열

#### 배열 생성과 초기화

```java
// 방법 1: 선언 후 생성
int[] numbers;
numbers = new int[5];

// 방법 2: 선언과 동시에 생성
int[] numbers = new int[5];

// 방법 3: 초기화와 함께
int[] numbers = {1, 2, 3, 4, 5};

// 방법 4: new와 함께 초기화
int[] numbers = new int[]{1, 2, 3, 4, 5};
```

#### 배열 순회

```java
int[] numbers = {10, 20, 30, 40, 50};

// 일반 for문
for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}

// 향상된 for문 (for-each)
for (int num : numbers) {
    System.out.println(num);
}
```

#### 다차원 배열

```java
// 2차원 배열
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

// 순회
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
}
```

#### 가변 인자 (Varargs)

```java
public static int sum(int... numbers) {
    int total = 0;
    for (int num : numbers) {
        total += num;
    }
    return total;
}

// 호출
sum(1, 2, 3);
sum(1, 2, 3, 4, 5);
```

---

### 5. Enum (열거형)

#### EnumExample.java

```java
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class EnumExample {
    public static void main(String[] args) {
        Day today = Day.MONDAY;

        switch (today) {
            case MONDAY:
                System.out.println("월요일입니다.");
                break;
            case FRIDAY:
                System.out.println("불금!");
                break;
            default:
                System.out.println("주중입니다.");
        }
    }
}
```

#### Enum 메서드

```java
// 모든 값 가져오기
for (Day day : Day.values()) {
    System.out.println(day);
}

// 문자열을 Enum으로 변환
Day day = Day.valueOf("MONDAY");

// 순서 (0부터 시작)
int order = Day.MONDAY.ordinal();  // 0

// 이름
String name = Day.MONDAY.name();   // "MONDAY"
```

---

### 6. Main 메서드 인자

#### MainArgumentsExample.java

```java
public class MainArgumentsExample {
    public static void main(String[] args) {
        System.out.println("인자 개수: " + args.length);

        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "]: " + args[i]);
        }
    }
}
```

**실행**:
```bash
mvn exec:java -pl chap03 -Dexec.mainClass="com.chap03.MainArgumentsExample" -Dexec.args="hello world 123"
```

---

## 실행 예제

```bash
# 문자열 비교
mvn exec:java -pl chap03 -Dexec.mainClass="com.chap03.StringCompareExample"

# 배열 생성
mvn exec:java -pl chap03 -Dexec.mainClass="com.chap03.ArrayCreationDemo"

# 다차원 배열
mvn exec:java -pl chap03 -Dexec.mainClass="com.chap03.MultiDimensionalArrayDemo"

# Enum 예제
mvn exec:java -pl chap03 -Dexec.mainClass="com.chap03.EnumExample"
```

---

## 베스트 프랙티스

### 1. 문자열 비교는 equals 사용
```java
// 나쁜 예
if (str == "hello") { }

// 좋은 예
if (str.equals("hello")) { }

// 더 안전한 예 (null 방지)
if ("hello".equals(str)) { }
```

### 2. switch에서 break 잊지 않기
```java
switch (value) {
    case 1:
        System.out.println("One");
        break;  // 필수!
    case 2:
        System.out.println("Two");
        break;
}
```

### 3. 배열 범위 체크
```java
if (index >= 0 && index < array.length) {
    System.out.println(array[index]);
}
```

---

## 연습 문제

1. **기본**: 성적(0-100)을 입력받아 A~F 등급을 출력하는 프로그램
2. **중급**: 문자열 배열에서 가장 긴 문자열 찾기
3. **고급**: 3×3 틱택토 게임판을 2차원 배열로 구현

---

## 다음 단계

**Chapter 04**에서 반복문(for, while)을 학습하여 반복 작업을 효율적으로 처리하세요.
