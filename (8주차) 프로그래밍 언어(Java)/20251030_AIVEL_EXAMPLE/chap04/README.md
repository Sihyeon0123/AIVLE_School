# Chapter 04: 반복문

> for, while, do-while 문을 사용하여 반복 작업을 효율적으로 처리하는 방법을 학습합니다.

## 학습 목표

- for 문으로 정해진 횟수만큼 반복
- while 문으로 조건에 따른 반복
- do-while 문의 특징 이해
- 향상된 for문(for-each) 활용
- break와 continue로 흐름 제어
- 중첩 반복문으로 복잡한 패턴 구현

## 파일 구성 (20개)

### 기본 반복문 (7개)
1. `ForDemo.java` - for 문 기본
2. `WhileDemo.java` - while 문 기본
3. `DoWhileDemo.java` - do-while 문
4. `EnhForDemo.java` - 향상된 for문 (for-each)
5. `CtrlFlow.java` - break, continue
6. `OddChecker.java` - 홀수 판별
7. `OddEvenChecker.java` - 홀짝 판별

### 패턴 출력 (8개)
8. `StarTriangle.java` - 별 삼각형 (for)
9. `InvertedStarTriangle.java` - 역삼각형 (for)
10. `Pyramid.java` - 피라미드 (for)
11. `TriangleWhile.java` - 삼각형 (while)
12. `InvertedTriangleWhile.java` - 역삼각형 (while)
13. `PyramidWhile.java` - 피라미드 (while)
14. `CharChecker.java` - 문자 판별
15. `CharCheckerWithSwitch.java` - 문자 판별 (switch)

### 제어문 응용 (5개)
16. `AgeGroup.java` - 연령대 분류
17. `MsgChecker.java` - 메시지 체커
18. `RPSGame.java` - 가위바위보 (if)
19. `RPSGameWithSwitch.java` - 가위바위보 (switch)
20. `BaseballGame.java` - 숫자 야구 게임

---

## 주요 개념

### 1. for 문

**문법**:
```java
for (초기화; 조건; 증감) {
    // 반복 실행할 코드
}
```

**예제**:
```java
// 1부터 10까지 출력
for (int i = 1; i <= 10; i++) {
    System.out.println(i);
}

// 역순 출력
for (int i = 10; i >= 1; i--) {
    System.out.println(i);
}

// 2씩 증가
for (int i = 0; i <= 10; i += 2) {
    System.out.println(i);  // 0, 2, 4, 6, 8, 10
}
```

**실행 순서**:
1. 초기화 (최초 1회)
2. 조건 검사
3. 조건이 true면 본문 실행
4. 증감 실행
5. 2번으로 돌아감

---

### 2. while 문

**문법**:
```java
while (조건) {
    // 반복 실행할 코드
}
```

**예제**:
```java
int i = 1;
while (i <= 10) {
    System.out.println(i);
    i++;
}

// 무한 루프
while (true) {
    // ...
    if (조건) break;
}
```

**for vs while**:
- **for**: 반복 횟수가 명확할 때
- **while**: 조건에 따라 반복할 때

---

### 3. do-while 문

**문법**:
```java
do {
    // 최소 1회 실행
} while (조건);
```

**특징**: 조건 검사 전에 **최소 1회 실행**

**예제**:
```java
int i = 0;
do {
    System.out.println(i);  // 0 출력 (조건이 false여도 1회 실행)
    i++;
} while (i < 0);
```

---

### 4. 향상된 for문 (for-each)

**문법**:
```java
for (타입 변수 : 배열_또는_컬렉션) {
    // 변수 사용
}
```

**예제**:
```java
int[] numbers = {10, 20, 30, 40, 50};

for (int num : numbers) {
    System.out.println(num);
}

String[] names = {"Alice", "Bob", "Charlie"};
for (String name : names) {
    System.out.println(name);
}
```

**장점**:
- 간결한 문법
- 인덱스 오류 방지

**제약**:
- 읽기 전용 (값 변경 불가)
- 인덱스 필요 시 일반 for문 사용

---

### 5. break와 continue

#### break - 반복문 탈출

```java
for (int i = 1; i <= 10; i++) {
    if (i == 5) {
        break;  // i가 5면 반복 종료
    }
    System.out.println(i);  // 1, 2, 3, 4
}
```

#### continue - 다음 반복으로

```java
for (int i = 1; i <= 10; i++) {
    if (i % 2 == 0) {
        continue;  // 짝수면 건너뛰기
    }
    System.out.println(i);  // 1, 3, 5, 7, 9
}
```

#### 레이블 (Label)

중첩 반복문에서 외부 루프 제어:

```java
outer:
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        if (i == 1 && j == 1) {
            break outer;  // 외부 반복문 탈출
        }
        System.out.println(i + ", " + j);
    }
}
```

---

### 6. 중첩 반복문

#### 구구단

```java
for (int i = 2; i <= 9; i++) {
    for (int j = 1; j <= 9; j++) {
        System.out.println(i + " × " + j + " = " + (i * j));
    }
}
```

#### 별 삼각형 (StarTriangle.java)

```java
for (int i = 1; i <= 5; i++) {
    for (int j = 1; j <= i; j++) {
        System.out.print("*");
    }
    System.out.println();
}
```

**출력**:
```
*
**
***
****
*****
```

#### 역삼각형 (InvertedStarTriangle.java)

```java
for (int i = 5; i >= 1; i--) {
    for (int j = 1; j <= i; j++) {
        System.out.print("*");
    }
    System.out.println();
}
```

**출력**:
```
*****
****
***
**
*
```

#### 피라미드 (Pyramid.java)

```java
int height = 5;
for (int i = 1; i <= height; i++) {
    // 공백 출력
    for (int j = 1; j <= height - i; j++) {
        System.out.print(" ");
    }
    // 별 출력
    for (int k = 1; k <= 2 * i - 1; k++) {
        System.out.print("*");
    }
    System.out.println();
}
```

**출력**:
```
    *
   ***
  *****
 *******
*********
```

---

### 7. 실전 예제

#### 가위바위보 게임 (RPSGame.java)

```java
import java.util.Scanner;
import java.util.Random;

public class RPSGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        String[] choices = {"가위", "바위", "보"};

        while (true) {
            System.out.print("가위(0), 바위(1), 보(2), 종료(-1): ");
            int user = sc.nextInt();

            if (user == -1) break;

            int computer = rand.nextInt(3);
            System.out.println("컴퓨터: " + choices[computer]);

            if (user == computer) {
                System.out.println("무승부!");
            } else if ((user == 0 && computer == 2) ||
                       (user == 1 && computer == 0) ||
                       (user == 2 && computer == 1)) {
                System.out.println("승리!");
            } else {
                System.out.println("패배!");
            }
        }
    }
}
```

#### 숫자 야구 게임 (BaseballGame.java)

3자리 숫자를 맞추는 게임:
- **Strike**: 숫자와 위치가 모두 맞음
- **Ball**: 숫자는 맞지만 위치가 틀림
- **Out**: 일치하는 숫자 없음

---

## 반복문 선택 가이드

| 상황 | 추천 반복문 | 이유 |
|------|------------|------|
| 정확한 반복 횟수 | `for` | 카운터 변수 관리 편리 |
| 조건 기반 반복 | `while` | 종료 조건이 명확 |
| 최소 1회 실행 | `do-while` | 조건 검사 전 실행 |
| 배열/컬렉션 순회 | `for-each` | 간결하고 안전 |

---

## 성능 최적화 팁

### 1. 반복문 밖으로 이동
```java
// 나쁜 예
for (int i = 0; i < array.length; i++) {
    int size = array.length;  // 매번 계산
}

// 좋은 예
int size = array.length;
for (int i = 0; i < size; i++) {
    // ...
}
```

### 2. 불필요한 계산 제거
```java
// 나쁜 예
for (int i = 0; i < array.length; i++) {
    for (int j = 0; j < array[i].length; j++) {
        // array.length를 매번 호출
    }
}

// 좋은 예
int outerLength = array.length;
for (int i = 0; i < outerLength; i++) {
    int innerLength = array[i].length;
    for (int j = 0; j < innerLength; j++) {
        // ...
    }
}
```

---

## 무한 루프 주의

### 무한 루프 예시

```java
// 의도한 무한 루프
while (true) {
    // 서버 실행 등
    if (종료조건) break;
}

// 실수로 인한 무한 루프
int i = 0;
while (i < 10) {
    System.out.println(i);
    // i++; 누락 → 무한 루프!
}
```

---

## 실행 예제

```bash
# for 문 기본
mvn exec:java -pl chap04 -Dexec.mainClass="com.chap04.ForDemo"

# while 문 기본
mvn exec:java -pl chap04 -Dexec.mainClass="com.chap04.WhileDemo"

# 별 삼각형
mvn exec:java -pl chap04 -Dexec.mainClass="com.chap04.StarTriangle"

# 피라미드
mvn exec:java -pl chap04 -Dexec.mainClass="com.chap04.Pyramid"

# 가위바위보
mvn exec:java -pl chap04 -Dexec.mainClass="com.chap04.RPSGame"

# 숫자 야구
mvn exec:java -pl chap04 -Dexec.mainClass="com.chap04.BaseballGame"
```

---

## 연습 문제

1. **기본**: 1부터 100까지의 합 구하기
2. **중급**: 구구단 전체 출력 (2단~9단)
3. **고급**: 소수(prime number) 판별 프로그램
4. **응용**: 다이아몬드 모양 별 출력
5. **게임**: 업다운 게임 (숫자 맞추기)

---

## 다음 단계

**Chapter 05**에서 배열을 학습하여 여러 데이터를 효율적으로 관리하세요.
