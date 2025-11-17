# Chapter 08: 제네릭

> 제네릭을 통해 타입 안전성을 확보하고 코드 재사용성을 극대화합니다.

## 학습 목표

- 제네릭의 개념과 필요성 이해
- 제네릭 클래스 작성 및 사용
- 제네릭 인터페이스 구현
- 제네릭 메서드 활용
- 와일드카드를 통한 유연한 타입 처리
- 타입 안전성과 코드 재사용성 향상

## 패키지 구조

```
com.chap08/
└── ex01_generics/         # 제네릭 종합 예제
    ├── GenericMain.java              # 제네릭 클래스 기본
    ├── MultiTypeGenericMain.java     # 다중 타입 파라미터
    ├── GenericMethod.java            # 제네릭 메서드
    ├── GenericInterfaceMain.java     # 제네릭 인터페이스
    └── GenericWildcard.java          # 와일드카드
```

## 제네릭이란?

제네릭(Generic)은 클래스나 메서드에서 사용할 타입을 컴파일 시점에 지정하는 기능입니다.

### 제네릭의 장점

1. **타입 안전성**: 컴파일 시점에 타입 체크
2. **형변환 불필요**: 타입 캐스팅 코드 제거
3. **코드 재사용성**: 하나의 코드로 여러 타입 지원

### 제네릭 사용 전 vs 후

**제네릭 사용 전**:
```java
List list = new ArrayList();
list.add("Hello");
String s = (String) list.get(0);  // 형변환 필요
```

**제네릭 사용 후**:
```java
List<String> list = new ArrayList<>();
list.add("Hello");
String s = list.get(0);  // 형변환 불필요
```

## 예제별 상세 내용

### GenericMain.java - 제네릭 클래스 기본

제네릭 클래스의 기본 사용법을 학습합니다.

```java
class GenericClass<T> {
    private T data;

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }
}

// 사용 예
GenericClass<String> stringInstance = new GenericClass<>();
stringInstance.setData("안녕, 제네릭");
String data = stringInstance.getData();

GenericClass<Integer> intInstance = new GenericClass<>();
intInstance.setData(123);
Integer intData = intInstance.getData();
```

**주요 개념**:
- `<T>`: 타입 파라미터 (Type Parameter)
- `T`는 관례적으로 사용하는 이름 (Type의 첫 글자)
- 객체 생성 시 실제 타입 지정

**학습 포인트**:
- 제네릭 클래스 선언 방법
- 타입 파라미터 사용
- 타입 안전성 확보

**실행**: `GenericMain.java`

---

### MultiTypeGenericMain.java - 다중 타입 파라미터

여러 개의 타입 파라미터를 사용하는 방법을 학습합니다.

```java
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }
}

// 사용 예
Pair<String, Integer> pair = new Pair<>("나이", 25);
String key = pair.getKey();
Integer value = pair.getValue();
```

**타입 파라미터 명명 규칙**:
- `T`: Type
- `E`: Element
- `K`: Key
- `V`: Value
- `N`: Number

**학습 포인트**:
- 다중 타입 파라미터 선언
- Key-Value 쌍 구현
- Map 구조의 이해

**실행**: `MultiTypeGenericMain.java`

---

### GenericMethod.java - 제네릭 메서드

제네릭 메서드의 활용법을 학습합니다.

```java
public class GenericMethod {
    // 제네릭 메서드 선언
    public static <T, V> boolean compare(People<T, V> person1, People<T, V> person2) {
        boolean nameCompare = person1.getName().equals(person2.getName());
        boolean ageCompare = person1.getAge().equals(person2.getAge());
        return nameCompare && ageCompare;
    }

    public static class People<T, V> {
        private T name;
        private V age;

        public People(T name, V age) {
            this.name = name;
            this.age = age;
        }

        public T getName() { return name; }
        public V getAge() { return age; }
    }

    public static void main(String[] args) {
        People<String, Integer> person1 = new People<>("John", 30);
        People<String, Integer> person2 = new People<>("John", 30);
        boolean isSame = compare(person1, person2);
        System.out.println("두 사람은 같은가? " + isSame);
    }
}
```

**제네릭 메서드 특징**:
- 메서드 단위로 타입 파라미터 선언
- 리턴 타입 앞에 `<T>` 선언
- 호출 시 타입 추론 가능

**학습 포인트**:
- 제네릭 메서드 선언 문법
- static 메서드에서 제네릭 사용
- 타입 추론 (Type Inference)

**실행**: `GenericMethod.java`

---

### GenericInterfaceMain.java - 제네릭 인터페이스

제네릭 인터페이스의 구현 방법을 학습합니다.

```java
interface Container<T> {
    void set(T item);
    T get();
}

class Box<T> implements Container<T> {
    private T item;

    @Override
    public void set(T item) {
        this.item = item;
    }

    @Override
    public T get() {
        return item;
    }
}

// 사용 예
Container<String> stringBox = new Box<>();
stringBox.set("Hello");
String value = stringBox.get();
```

**학습 포인트**:
- 제네릭 인터페이스 선언
- 제네릭 인터페이스 구현
- 인터페이스와 제네릭의 조합

**실행**: `GenericInterfaceMain.java`

---

### GenericWildcard.java - 와일드카드

와일드카드를 통한 유연한 타입 처리를 학습합니다.

```java
// 무제한 와일드카드
public static void printList(List<?> list) {
    for (Object obj : list) {
        System.out.println(obj);
    }
}

// 상한 경계 와일드카드 (Upper Bound)
public static void printNumbers(List<? extends Number> list) {
    for (Number num : list) {
        System.out.println(num.doubleValue());
    }
}

// 하한 경계 와일드카드 (Lower Bound)
public static void addNumbers(List<? super Integer> list) {
    list.add(1);
    list.add(2);
}

// 사용 예
List<Integer> intList = Arrays.asList(1, 2, 3);
List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);

printList(intList);           // 어떤 타입이든 가능
printNumbers(intList);        // Number의 하위 타입
printNumbers(doubleList);     // Number의 하위 타입
```

**와일드카드 종류**:

| 와일드카드 | 표기법 | 의미 | 사용 예 |
|----------|--------|------|---------|
| 무제한 | `<?>` | 모든 타입 가능 | `List<?>` |
| 상한 경계 | `<? extends T>` | T와 T의 하위 타입 | `List<? extends Number>` |
| 하한 경계 | `<? super T>` | T와 T의 상위 타입 | `List<? super Integer>` |

**PECS 원칙** (Producer Extends, Consumer Super):
- **Extends**: 데이터를 읽기만 할 때 (Producer)
- **Super**: 데이터를 쓰기만 할 때 (Consumer)

**학습 포인트**:
- 와일드카드의 필요성
- 상한/하한 경계 와일드카드
- PECS 원칙 이해

**실행**: `GenericWildcard.java`

---

## 제네릭 제약사항

### 1. 기본 타입(Primitive Type) 사용 불가
```java
// 잘못된 예
GenericClass<int> instance = new GenericClass<>();  // 컴파일 에러

// 올바른 예
GenericClass<Integer> instance = new GenericClass<>();  // 래퍼 클래스 사용
```

### 2. static 멤버에 타입 파라미터 사용 불가
```java
class GenericClass<T> {
    // 컴파일 에러
    private static T data;

    // 컴파일 에러
    public static T getData() {
        return data;
    }
}
```

### 3. 제네릭 배열 생성 불가
```java
// 컴파일 에러
T[] array = new T[10];

// 대안: 리스트 사용
List<T> list = new ArrayList<>();
```

### 4. instanceof 연산자 사용 제약
```java
// 컴파일 에러
if (obj instanceof GenericClass<String>) { }

// 가능
if (obj instanceof GenericClass<?>) { }
```

## 권장 학습 순서

1. **GenericMain** - 제네릭 클래스 기본 이해
2. **MultiTypeGenericMain** - 다중 타입 파라미터 학습
3. **GenericMethod** - 제네릭 메서드 활용
4. **GenericInterfaceMain** - 제네릭 인터페이스 구현
5. **GenericWildcard** - 와일드카드로 유연성 확보

## 실행 방법

### IntelliJ에서 실행
각 예제의 `*Main.java` 파일을 열고 실행 버튼을 클릭합니다.

### 명령줄에서 실행
```bash
# 제네릭 클래스 기본
mvn exec:java -pl chap08 -Dexec.mainClass="com.chap08.ex01_generics.GenericMain"

# 다중 타입 파라미터
mvn exec:java -pl chap08 -Dexec.mainClass="com.chap08.ex01_generics.MultiTypeGenericMain"

# 제네릭 메서드
mvn exec:java -pl chap08 -Dexec.mainClass="com.chap08.ex01_generics.GenericMethod"

# 제네릭 인터페이스
mvn exec:java -pl chap08 -Dexec.mainClass="com.chap08.ex01_generics.GenericInterfaceMain"

# 와일드카드
mvn exec:java -pl chap08 -Dexec.mainClass="com.chap08.ex01_generics.GenericWildcard"
```

## 주요 개념 정리

### 타입 소거 (Type Erasure)
Java의 제네릭은 컴파일 시점에만 타입 검사를 수행하고, 런타임에는 타입 정보가 제거됩니다.

```java
// 컴파일 시
List<String> stringList = new ArrayList<String>();

// 런타임 시 (타입 소거 후)
List stringList = new ArrayList();
```

**이유**:
- 하위 호환성 유지
- 기존 코드와의 통합

### 타입 안전성
제네릭을 사용하면 컴파일 시점에 타입 체크가 이루어져 런타임 오류를 방지할 수 있습니다.

```java
// 제네릭 없이
List list = new ArrayList();
list.add("Hello");
list.add(123);
String s = (String) list.get(1);  // ClassCastException 발생!

// 제네릭 사용
List<String> list = new ArrayList<>();
list.add("Hello");
list.add(123);  // 컴파일 에러! 타입 불일치
```

## 실전 활용 사례

### 1. 재사용 가능한 유틸리티 클래스
```java
public class Result<T> {
    private boolean success;
    private T data;
    private String errorMessage;

    public static <T> Result<T> success(T data) {
        return new Result<>(true, data, null);
    }

    public static <T> Result<T> failure(String errorMessage) {
        return new Result<>(false, null, errorMessage);
    }
}
```

### 2. 제네릭 DAO 패턴
```java
interface Repository<T, ID> {
    T findById(ID id);
    List<T> findAll();
    void save(T entity);
    void delete(ID id);
}

class UserRepository implements Repository<User, Long> {
    // User 엔티티에 대한 구현
}
```

## 연습 문제

1. **기본**: `Stack<T>` 제네릭 클래스를 만들고 `push()`, `pop()` 메서드를 구현해보세요.

2. **중급**: `Triple<A, B, C>` 클래스를 만들어 3개의 서로 다른 타입을 저장해보세요.

3. **고급**: 제네릭을 사용하여 `swap(T[] array, int i, int j)` 메서드를 구현하고, 다양한 타입의 배열에서 테스트해보세요.

## 관련 개념

- **Chapter 07**: 제네릭 인터페이스의 기반이 되는 인터페이스 개념
- **Chapter 10**: 제네릭을 활용한 컬렉션 프레임워크

## 참고 자료

- [Oracle Java Tutorials - Generics](https://docs.oracle.com/javase/tutorial/java/generics/)
- [Effective Java - Item 26~31 (Generics)](https://www.oreilly.com/library/view/effective-java/9780134686097/)

---

**다음 단계**: Chapter 09에서 예외 처리를 학습하여 안정적인 프로그램을 작성하세요.
