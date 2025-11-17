# Chapter 05: 배열

> 배열을 사용하여 여러 개의 데이터를 효율적으로 관리하는 방법을 학습합니다.

## 학습 목표

- 배열의 개념과 필요성 이해
- 1차원 및 다차원 배열 활용
- 배열과 반복문의 조합
- 배열을 활용한 알고리즘 구현
- 참조 타입의 특성 이해

## 파일 구성 (13개)

### 배열 기초 (5개)
1. `Demo.java` - 배열 기본 데모
2. `ObjCreateDemo.java` - 객체 생성 데모
3. `Prim.java` - 기본형 배열
4. `Cls.java` - 클래스와 배열
5. `NumBox.java` - 숫자 박스 예제

### 도형 클래스 (4개)
6. `Circle.java` - 원 클래스
7. `ConstructCircle.java` - 생성자를 사용한 원
8. `Rect.java` - 사각형 클래스
9. `Square.java` - 정사각형 클래스

### 계산과 활용 (4개)
10. `Calc.java` - 계산기 클래스
11. `Person.java` - 사람 클래스
12. `Person0.java` - 사람 클래스 변형
13. `Chap05Main.java` - 메인 실행 클래스

---

## 주요 개념

### 1. 배열이란?

같은 타입의 여러 데이터를 하나의 변수로 관리하는 자료구조입니다.

**배열 없이 (비효율적)**:
```java
int score1 = 90;
int score2 = 85;
int score3 = 88;
int score4 = 92;
int score5 = 95;

int sum = score1 + score2 + score3 + score4 + score5;
```

**배열 사용 (효율적)**:
```java
int[] scores = {90, 85, 88, 92, 95};

int sum = 0;
for (int score : scores) {
    sum += score;
}
```

---

### 2. 배열 선언과 생성

#### 선언
```java
int[] numbers;        // 권장
int numbers[];        // 가능하지만 비권장
```

#### 생성
```java
// 방법 1: 크기 지정
numbers = new int[5];  // 기본값 0으로 초기화

// 방법 2: 초기값 지정
numbers = new int[]{10, 20, 30, 40, 50};

// 방법 3: 선언과 동시에 초기화
int[] numbers = {10, 20, 30, 40, 50};
```

---

### 3. 배열 기본값

| 타입 | 기본값 |
|------|--------|
| `int`, `byte`, `short`, `long` | `0` |
| `float`, `double` | `0.0` |
| `boolean` | `false` |
| `char` | `'\u0000'` |
| 참조 타입 (객체) | `null` |

---

### 4. 배열 접근

```java
int[] numbers = {10, 20, 30, 40, 50};

// 읽기
int first = numbers[0];   // 10
int last = numbers[4];    // 50

// 쓰기
numbers[0] = 100;

// 길이
int length = numbers.length;  // 5

// 주의: 인덱스는 0부터 시작, 마지막은 length-1
```

---

### 5. 배열 순회

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

---

### 6. 다차원 배열

#### 2차원 배열

```java
// 선언 및 생성
int[][] matrix = new int[3][4];  // 3행 4열

// 초기화
int[][] matrix = {
    {1, 2, 3, 4},
    {5, 6, 7, 8},
    {9, 10, 11, 12}
};

// 접근
int value = matrix[1][2];  // 7

// 순회
for (int i = 0; i < matrix.length; i++) {           // 행
    for (int j = 0; j < matrix[i].length; j++) {    // 열
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
}
```

#### 가변 배열

```java
int[][] jagged = new int[3][];
jagged[0] = new int[2];  // 첫 행은 2개
jagged[1] = new int[4];  // 둘째 행은 4개
jagged[2] = new int[3];  // 셋째 행은 3개
```

---

### 7. 객체 배열

#### Circle 배열 예제

```java
// Circle.java
class Circle {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double getArea() {
        return Math.PI * radius * radius;
    }
}

// 사용
Circle[] circles = new Circle[3];
circles[0] = new Circle(1.0);
circles[1] = new Circle(2.0);
circles[2] = new Circle(3.0);

for (Circle c : circles) {
    System.out.println("면적: " + c.getArea());
}
```

---

### 8. 배열 복사

#### 얕은 복사 (참조만 복사)

```java
int[] arr1 = {1, 2, 3};
int[] arr2 = arr1;  // 같은 배열을 참조

arr2[0] = 100;
System.out.println(arr1[0]);  // 100 (같이 변경됨)
```

#### 깊은 복사 (값 복사)

```java
// 방법 1: 반복문
int[] arr1 = {1, 2, 3};
int[] arr2 = new int[arr1.length];
for (int i = 0; i < arr1.length; i++) {
    arr2[i] = arr1[i];
}

// 방법 2: System.arraycopy()
int[] arr3 = new int[arr1.length];
System.arraycopy(arr1, 0, arr3, 0, arr1.length);

// 방법 3: Arrays.copyOf()
int[] arr4 = Arrays.copyOf(arr1, arr1.length);

// 방법 4: clone()
int[] arr5 = arr1.clone();
```

---

### 9. 배열 정렬과 검색

```java
import java.util.Arrays;

int[] numbers = {5, 2, 8, 1, 9};

// 정렬
Arrays.sort(numbers);  // {1, 2, 5, 8, 9}

// 이진 검색 (정렬된 배열에서)
int index = Arrays.binarySearch(numbers, 5);  // 2

// 배열 비교
int[] arr1 = {1, 2, 3};
int[] arr2 = {1, 2, 3};
boolean equal = Arrays.equals(arr1, arr2);  // true

// 배열 채우기
int[] arr = new int[5];
Arrays.fill(arr, 10);  // {10, 10, 10, 10, 10}

// 배열 문자열 변환
System.out.println(Arrays.toString(numbers));  // [1, 2, 5, 8, 9]
```

---

### 10. 실전 예제

#### 최대값/최소값 찾기

```java
int[] numbers = {45, 23, 67, 12, 89, 34};

int max = numbers[0];
int min = numbers[0];

for (int num : numbers) {
    if (num > max) max = num;
    if (num < min) min = num;
}

System.out.println("최대값: " + max);  // 89
System.out.println("최소값: " + min);  // 12
```

#### 평균 계산

```java
int[] scores = {90, 85, 88, 92, 95};

int sum = 0;
for (int score : scores) {
    sum += score;
}

double average = (double) sum / scores.length;
System.out.println("평균: " + average);  // 90.0
```

#### 배열 뒤집기

```java
int[] arr = {1, 2, 3, 4, 5};

for (int i = 0; i < arr.length / 2; i++) {
    int temp = arr[i];
    arr[i] = arr[arr.length - 1 - i];
    arr[arr.length - 1 - i] = temp;
}

System.out.println(Arrays.toString(arr));  // [5, 4, 3, 2, 1]
```

---

## 참조 타입의 특성

### 기본형 vs 참조형

```java
// 기본형 (값 복사)
int a = 10;
int b = a;
b = 20;
System.out.println(a);  // 10 (변경 안 됨)

// 참조형 (주소 복사)
int[] arr1 = {10};
int[] arr2 = arr1;
arr2[0] = 20;
System.out.println(arr1[0]);  // 20 (같이 변경됨)
```

### null 체크

```java
int[] numbers = null;

if (numbers != null && numbers.length > 0) {
    System.out.println(numbers[0]);
} else {
    System.out.println("배열이 비어있습니다.");
}
```

---

## 배열 사용 시 주의사항

### 1. ArrayIndexOutOfBoundsException

```java
int[] arr = {1, 2, 3};
// int value = arr[3];  // 예외 발생! (인덱스는 0~2)

// 안전한 접근
if (index >= 0 && index < arr.length) {
    int value = arr[index];
}
```

### 2. NullPointerException

```java
int[] arr = null;
// int length = arr.length;  // 예외 발생!

// null 체크
if (arr != null) {
    int length = arr.length;
}
```

### 3. 배열 크기 변경 불가

```java
int[] arr = {1, 2, 3};
// arr.length = 5;  // 컴파일 에러! 크기 변경 불가

// 새 배열 생성 필요
int[] newArr = Arrays.copyOf(arr, 5);  // 크기 5인 새 배열
```

---

## 실행 예제

```bash
# 배열 데모
mvn exec:java -pl chap05 -Dexec.mainClass="com.chap05.Demo"

# 원 배열
mvn exec:java -pl chap05 -Dexec.mainClass="com.chap05.ConstructCircle"

# 메인 실행
mvn exec:java -pl chap05 -Dexec.mainClass="com.chap05.Chap05Main"
```

---

## 연습 문제

1. **기본**: 정수 배열에서 짝수만 출력하기
2. **중급**: 두 배열을 합쳐서 정렬된 배열 만들기
3. **고급**: 학생 점수 배열에서 등수 매기기
4. **응용**: 로또 번호 생성기 (1~45 중 중복 없이 6개)

---

## 배열의 한계와 대안

### 한계
- 크기 고정 (동적 크기 조절 불가)
- 삽입/삭제가 비효율적
- 타입이 고정

### 대안
- **ArrayList**: 동적 크기 조절 (Chapter 10)
- **LinkedList**: 삽입/삭제 효율적
- **제네릭**: 타입 안전성

---

## 다음 단계

**Chapter 06**에서 클래스와 상속을 학습하여 객체지향 프로그래밍의 세계로 들어가세요.
