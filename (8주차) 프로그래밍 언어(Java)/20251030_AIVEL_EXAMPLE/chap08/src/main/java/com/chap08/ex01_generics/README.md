# ex01_generics - 제네릭 종합

> 제네릭 클래스, 인터페이스, 메서드, 와일드카드를 모두 학습합니다.

## 파일 구성

1. `GenericMain.java` - 제네릭 클래스 기본
2. `MultiTypeGenericMain.java` - 다중 타입 파라미터
3. `GenericMethod.java` - 제네릭 메서드
4. `GenericInterfaceMain.java` - 제네릭 인터페이스
5. `GenericWildcard.java` - 와일드카드

## 학습 순서

### 1단계: GenericMain.java - 제네릭 클래스 기본

**학습 목표**: 제네릭의 필요성과 기본 문법 이해

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

// 사용
GenericClass<String> stringInstance = new GenericClass<>();
stringInstance.setData("안녕, 제네릭");
String data = stringInstance.getData();  // 형변환 불필요!
```

**핵심 포인트**:
- `<T>`: 타입 파라미터 (관례상 대문자 한 글자)
- 타입 안전성 확보
- 형변환 코드 제거

**실행**:
```bash
mvn exec:java -pl chap08 -Dexec.mainClass="com.chap08.ex01_generics.GenericMain"
```

---

### 2단계: MultiTypeGenericMain.java - 다중 타입 파라미터

**학습 목표**: 여러 개의 타입 파라미터 사용

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

// 사용
Pair<String, Integer> pair = new Pair<>("나이", 25);
```

**타입 파라미터 네이밍 컨벤션**:
- `T`: Type
- `E`: Element
- `K`: Key
- `V`: Value
- `N`: Number
- `R`: Result

**핵심 포인트**:
- 2개 이상의 타입 파라미터 사용
- Map, Entry 등의 구조 이해

**실행**:
```bash
mvn exec:java -pl chap08 -Dexec.mainClass="com.chap08.ex01_generics.MultiTypeGenericMain"
```

---

### 3단계: GenericMethod.java - 제네릭 메서드

**학습 목표**: 메서드 레벨 제네릭 사용

```java
public class GenericMethod {
    // 제네릭 메서드 선언
    public static <T, V> boolean compare(People<T, V> p1, People<T, V> p2) {
        boolean nameCompare = p1.getName().equals(p2.getName());
        boolean ageCompare = p1.getAge().equals(p2.getAge());
        return nameCompare && ageCompare;
    }
}

// 사용
People<String, Integer> person1 = new People<>("John", 30);
People<String, Integer> person2 = new People<>("John", 30);
boolean isSame = compare(person1, person2);  // 타입 추론
```

**핵심 포인트**:
- 리턴 타입 앞에 `<T, V>` 선언
- 메서드 호출 시 타입 추론 가능
- static 메서드에서도 제네릭 사용 가능

**실행**:
```bash
mvn exec:java -pl chap08 -Dexec.mainClass="com.chap08.ex01_generics.GenericMethod"
```

---

### 4단계: GenericInterfaceMain.java - 제네릭 인터페이스

**학습 목표**: 인터페이스에 제네릭 적용

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
```

**핵심 포인트**:
- 인터페이스도 제네릭 사용 가능
- 구현 클래스는 타입 파라미터를 그대로 전달하거나 구체화
- Java 컬렉션 프레임워크의 기본 원리

**실행**:
```bash
mvn exec:java -pl chap08 -Dexec.mainClass="com.chap08.ex01_generics.GenericInterfaceMain"
```

---

### 5단계: GenericWildcard.java - 와일드카드

**학습 목표**: 유연한 타입 처리를 위한 와일드카드

#### 무제한 와일드카드 `<?>`
```java
public static void printList(List<?> list) {
    for (Object obj : list) {
        System.out.println(obj);
    }
}
```

#### 상한 경계 와일드카드 `<? extends T>`
```java
public static void printNumbers(List<? extends Number> list) {
    for (Number num : list) {
        System.out.println(num.doubleValue());
    }
}

// 사용
List<Integer> intList = Arrays.asList(1, 2, 3);
List<Double> doubleList = Arrays.asList(1.1, 2.2);
printNumbers(intList);    // OK
printNumbers(doubleList); // OK
```

#### 하한 경계 와일드카드 `<? super T>`
```java
public static void addNumbers(List<? super Integer> list) {
    list.add(1);
    list.add(2);
}

// 사용
List<Number> numList = new ArrayList<>();
addNumbers(numList);  // OK
```

#### PECS 원칙
**Producer Extends, Consumer Super**

- **Extends**: 데이터를 **읽기**만 할 때 (Producer)
  ```java
  List<? extends Number> list = ...;
  Number num = list.get(0);  // OK (읽기)
  // list.add(1);  // 컴파일 에러 (쓰기 불가)
  ```

- **Super**: 데이터를 **쓰기**만 할 때 (Consumer)
  ```java
  List<? super Integer> list = ...;
  list.add(1);  // OK (쓰기)
  // Integer num = list.get(0);  // 컴파일 에러 (Object만 가능)
  ```

**핵심 포인트**:
- 와일드카드로 유연성 확보
- PECS 원칙 이해
- 컬렉션 메서드 설계 시 활용

**실행**:
```bash
mvn exec:java -pl chap08 -Dexec.mainClass="com.chap08.ex01_generics.GenericWildcard"
```

---

## 제네릭 사용 시 주의사항

### 1. 기본 타입 사용 불가
```java
GenericClass<int> instance = ...;     // 컴파일 에러!
GenericClass<Integer> instance = ...; // OK
```

### 2. 타입 소거 (Type Erasure)
런타임에는 타입 정보가 제거됩니다.

```java
List<String> stringList = new ArrayList<>();
List<Integer> intList = new ArrayList<>();

// 런타임에는 둘 다 List로 취급
stringList.getClass() == intList.getClass()  // true
```

### 3. static 멤버에 타입 파라미터 사용 불가
```java
class GenericClass<T> {
    // private static T data;  // 컴파일 에러!
}
```

### 4. 제네릭 배열 생성 불가
```java
// T[] array = new T[10];  // 컴파일 에러!
List<T> list = new ArrayList<>();  // OK (대안)
```

## 실전 활용 예제

### Result 래퍼 클래스
```java
public class Result<T> {
    private boolean success;
    private T data;
    private String errorMessage;

    public static <T> Result<T> success(T data) {
        return new Result<>(true, data, null);
    }

    public static <T> Result<T> failure(String error) {
        return new Result<>(false, null, error);
    }
}

// 사용
Result<User> result = userService.findById(1);
if (result.isSuccess()) {
    User user = result.getData();
}
```

### 제네릭 DAO
```java
interface Repository<T, ID> {
    T findById(ID id);
    List<T> findAll();
    void save(T entity);
    void delete(ID id);
}

class UserRepository implements Repository<User, Long> {
    // User 엔티티에 대한 CRUD 구현
}
```

## 정리

| 개념 | 문법 | 용도 |
|------|------|------|
| 제네릭 클래스 | `class Box<T>` | 클래스 레벨 타입 파라미터 |
| 제네릭 메서드 | `<T> void method(T param)` | 메서드 레벨 타입 파라미터 |
| 제네릭 인터페이스 | `interface List<E>` | 인터페이스에 타입 파라미터 |
| 무제한 와일드카드 | `List<?>` | 모든 타입 |
| 상한 경계 | `List<? extends T>` | T와 하위 타입 (읽기) |
| 하한 경계 | `List<? super T>` | T와 상위 타입 (쓰기) |

## 다음 단계

Chapter 8 완료! **Chapter 09**에서 예외 처리를 학습하세요.
