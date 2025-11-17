# Chapter 10: 컬렉션

> Java 컬렉션 프레임워크를 활용하여 효율적인 데이터 관리 방법을 학습합니다.

## 학습 목표

- 컬렉션 프레임워크의 개념과 필요성 이해
- List, Set, Map의 특징과 차이점 파악
- ArrayList, LinkedList의 특성 이해
- HashSet, TreeSet의 활용법 학습
- HashMap, Hashtable의 차이점 이해
- Queue를 활용한 FIFO 구조 구현

## 파일 구성 (10개)

### List 구현 (3개)
1. `ArrayListMain.java` - ArrayList 기본
2. `LinkedListMain.java` - LinkedList 기본
3. `CustomLinkedListMain.java` - 직접 구현한 LinkedList

### Set 구현 (4개)
4. `HashSetMain.java` - HashSet 기본
5. `HashSetSpeed.java` - HashSet 성능 테스트
6. `LinkedHashSetMain.java` - LinkedHashSet (순서 유지)
7. `TreeSetMain.java` - TreeSet (정렬)

### Map 구현 (2개)
8. `HashMapMain.java` - HashMap 기본
9. `HashtableMain.java` - Hashtable (동기화)

### Queue (1개)
10. `QueueMain.java` - Queue 기본

---

## 컬렉션 프레임워크란?

데이터를 효율적으로 저장하고 관리하기 위한 자료구조 모음입니다.

### 배열의 한계와 컬렉션의 장점

| 특징 | 배열 | 컬렉션 |
|------|------|--------|
| 크기 | 고정 | 동적 |
| 타입 | 기본형/참조형 | 참조형만 (Wrapper 사용) |
| 메서드 | 제한적 | 풍부함 (add, remove 등) |
| 성능 | 빠름 | 약간 느림 |

---

## 컬렉션 계층 구조

```
Collection (인터페이스)
├── List (인터페이스)
│   ├── ArrayList
│   ├── LinkedList
│   └── Vector
├── Set (인터페이스)
│   ├── HashSet
│   ├── LinkedHashSet
│   └── TreeSet
└── Queue (인터페이스)
    └── LinkedList

Map (인터페이스, Collection과 별개)
├── HashMap
├── LinkedHashMap
├── TreeMap
└── Hashtable
```

---

## 1. List - 순서가 있는 컬렉션

### ArrayList

동적 배열로 구현된 리스트입니다.

```java
import java.util.ArrayList;
import java.util.List;

public class ArrayListMain {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        // 추가
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // 특정 위치에 추가
        list.add(1, "Apricot");

        // 읽기
        String fruit = list.get(0);  // "Apple"

        // 크기
        int size = list.size();  // 4

        // 삭제
        list.remove(0);              // 인덱스로 삭제
        list.remove("Banana");       // 값으로 삭제

        // 검색
        boolean contains = list.contains("Cherry");  // true
        int index = list.indexOf("Cherry");          // 2

        // 순회
        for (String s : list) {
            System.out.println(s);
        }

        // 정렬
        Collections.sort(list);

        // 모두 삭제
        list.clear();
    }
}
```

**특징**:
- 인덱스 기반 빠른 접근 (O(1))
- 중간 삽입/삭제 느림 (O(n))
- 순서 유지
- 중복 허용

**실행**:
```bash
mvn exec:java -pl chap10 -Dexec.mainClass="com.chap10.ArrayListMain"
```

---

### LinkedList

연결 리스트로 구현된 리스트입니다.

```java
import java.util.LinkedList;
import java.util.List;

public class LinkedListMain {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        // 앞에 추가
        list.add(0, "Z");

        // LinkedList는 Queue 인터페이스도 구현
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addFirst("First");
        linkedList.addLast("Last");
        linkedList.removeFirst();
        linkedList.removeLast();
    }
}
```

**특징**:
- 중간 삽입/삭제 빠름 (O(1), 위치만 알면)
- 인덱스 접근 느림 (O(n))
- Queue/Deque 구현
- 메모리 오버헤드 (노드 포인터)

**실행**:
```bash
mvn exec:java -pl chap10 -Dexec.mainClass="com.chap10.LinkedListMain"
```

---

### ArrayList vs LinkedList

| 연산 | ArrayList | LinkedList | 권장 |
|------|-----------|------------|------|
| 읽기 (get) | O(1) ⚡ | O(n) | ArrayList |
| 끝에 추가 | O(1) ⚡ | O(1) ⚡ | 둘 다 |
| 중간 삽입/삭제 | O(n) | O(1) ⚡ | LinkedList |
| 검색 (contains) | O(n) | O(n) | 둘 다 |

**선택 기준**:
- **ArrayList**: 읽기가 많고, 끝에 추가/삭제가 주된 작업
- **LinkedList**: 중간 삽입/삭제가 많은 경우

---

## 2. Set - 중복 없는 컬렉션

### HashSet

해시 테이블로 구현된 집합입니다.

```java
import java.util.HashSet;
import java.util.Set;

public class HashSetMain {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        // 추가 (중복 무시)
        set.add("Apple");
        set.add("Banana");
        set.add("Apple");  // 중복, 무시됨

        System.out.println(set.size());  // 2

        // 포함 여부
        boolean has = set.contains("Apple");  // true

        // 삭제
        set.remove("Banana");

        // 순회 (순서 보장 안 됨)
        for (String s : set) {
            System.out.println(s);
        }
    }
}
```

**특징**:
- 중복 불가
- 순서 없음
- 빠른 검색 (O(1))
- null 허용 (1개만)

**실행**:
```bash
mvn exec:java -pl chap10 -Dexec.mainClass="com.chap10.HashSetMain"
```

---

### LinkedHashSet

삽입 순서를 유지하는 HashSet입니다.

```java
Set<String> set = new LinkedHashSet<>();
set.add("Banana");
set.add("Apple");
set.add("Cherry");

for (String s : set) {
    System.out.println(s);  // Banana, Apple, Cherry (순서 유지)
}
```

**실행**:
```bash
mvn exec:java -pl chap10 -Dexec.mainClass="com.chap10.LinkedHashSetMain"
```

---

### TreeSet

정렬된 순서를 유지하는 집합입니다.

```java
import java.util.TreeSet;
import java.util.Set;

public class TreeSetMain {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();

        set.add(5);
        set.add(1);
        set.add(3);

        for (int num : set) {
            System.out.println(num);  // 1, 3, 5 (자동 정렬)
        }

        // TreeSet만의 메서드
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(10);
        treeSet.add(20);
        treeSet.add(30);

        System.out.println(treeSet.first());   // 10 (최소값)
        System.out.println(treeSet.last());    // 30 (최대값)
        System.out.println(treeSet.lower(20)); // 10 (20보다 작은 값)
        System.out.println(treeSet.higher(20));// 30 (20보다 큰 값)
    }
}
```

**특징**:
- 중복 불가
- 자동 정렬
- 느린 연산 (O(log n))
- Red-Black Tree 구현

**실행**:
```bash
mvn exec:java -pl chap10 -Dexec.mainClass="com.chap10.TreeSetMain"
```

---

### Set 구현 비교

| 특징 | HashSet | LinkedHashSet | TreeSet |
|------|---------|---------------|---------|
| 순서 | ❌ | ✅ (삽입 순서) | ✅ (정렬) |
| 성능 | O(1) ⚡ | O(1) | O(log n) |
| 용도 | 중복 제거 | 순서 유지 | 정렬 필요 |

---

## 3. Map - Key-Value 쌍

### HashMap

해시 테이블로 구현된 맵입니다.

```java
import java.util.HashMap;
import java.util.Map;

public class HashMapMain {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        // 추가/수정
        map.put("Apple", 100);
        map.put("Banana", 200);
        map.put("Apple", 150);  // 키 중복 시 값 업데이트

        // 읽기
        int price = map.get("Apple");  // 150

        // 기본값 반환
        int orange = map.getOrDefault("Orange", 0);  // 0

        // 존재 여부
        boolean has = map.containsKey("Banana");    // true
        boolean hasValue = map.containsValue(200);  // true

        // 삭제
        map.remove("Banana");

        // 크기
        int size = map.size();

        // 순회 1: entrySet
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // 순회 2: keySet
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }

        // 순회 3: values
        for (int value : map.values()) {
            System.out.println(value);
        }
    }
}
```

**특징**:
- Key 중복 불가, Value 중복 가능
- 순서 없음
- 빠른 검색 (O(1))
- null Key 허용 (1개), null Value 허용

**실행**:
```bash
mvn exec:java -pl chap10 -Dexec.mainClass="com.chap10.HashMapMain"
```

---

### Hashtable

동기화된 HashMap입니다.

```java
import java.util.Hashtable;
import java.util.Map;

public class HashtableMain {
    public static void main(String[] args) {
        Map<String, String> table = new Hashtable<>();

        table.put("id", "admin");
        table.put("pw", "1234");

        // table.put(null, "value");  // NullPointerException
        // table.put("key", null);    // NullPointerException
    }
}
```

**HashMap vs Hashtable**:

| 특징 | HashMap | Hashtable |
|------|---------|-----------|
| 동기화 | ❌ | ✅ |
| null 허용 | ✅ | ❌ |
| 성능 | 빠름 ⚡ | 느림 |
| 권장 | 단일 스레드 | 멀티 스레드 |

**참고**: 멀티 스레드 환경에서는 `ConcurrentHashMap` 권장

**실행**:
```bash
mvn exec:java -pl chap10 -Dexec.mainClass="com.chap10.HashtableMain"
```

---

## 4. Queue - FIFO 구조

### Queue 인터페이스

선입선출(First In First Out) 구조입니다.

```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueMain {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        // 추가
        queue.offer("First");
        queue.offer("Second");
        queue.offer("Third");

        // 앞 요소 확인 (제거 안 함)
        String front = queue.peek();  // "First"

        // 앞 요소 꺼내기 (제거)
        String removed = queue.poll();  // "First"

        System.out.println(queue.size());  // 2

        // 모두 꺼내기
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
```

**Queue 메서드**:

| 메서드 | 동작 | 실패 시 |
|--------|------|---------|
| `offer(e)` | 추가 | false 반환 |
| `poll()` | 제거하고 반환 | null 반환 |
| `peek()` | 확인 (제거 안 함) | null 반환 |
| `add(e)` | 추가 | 예외 발생 |
| `remove()` | 제거하고 반환 | 예외 발생 |
| `element()` | 확인 | 예외 발생 |

**실행**:
```bash
mvn exec:java -pl chap10 -Dexec.mainClass="com.chap10.QueueMain"
```

---

## 제네릭과 컬렉션

### 타입 안전성

```java
// 제네릭 없이 (위험)
List list = new ArrayList();
list.add("String");
list.add(123);
String s = (String) list.get(1);  // ClassCastException!

// 제네릭 사용 (안전)
List<String> list = new ArrayList<>();
list.add("String");
// list.add(123);  // 컴파일 에러!
String s = list.get(0);  // 형변환 불필요
```

---

## 컬렉션 유틸리티

### Collections 클래스

```java
import java.util.Collections;

List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5));

// 정렬
Collections.sort(list);  // [1, 1, 3, 4, 5]

// 역순 정렬
Collections.reverse(list);  // [5, 4, 3, 1, 1]

// 섞기
Collections.shuffle(list);

// 최대/최소
int max = Collections.max(list);
int min = Collections.min(list);

// 채우기
Collections.fill(list, 0);  // 모든 요소를 0으로

// 빈도수
int freq = Collections.frequency(list, 1);  // 1의 개수

// 불변 컬렉션
List<String> immutable = Collections.unmodifiableList(list);
```

---

## 컬렉션 선택 가이드

### List 선택

```
읽기가 많다 → ArrayList
중간 삽입/삭제가 많다 → LinkedList
스레드 안전 필요 → Vector (비권장) 또는 CopyOnWriteArrayList
```

### Set 선택

```
중복 제거만 필요 → HashSet
순서 유지 필요 → LinkedHashSet
정렬 필요 → TreeSet
```

### Map 선택

```
일반적인 용도 → HashMap
순서 유지 → LinkedHashMap
정렬 필요 → TreeMap
스레드 안전 → ConcurrentHashMap
```

---

## 성능 비교 (Big-O)

| 자료구조 | 접근 | 검색 | 삽입 | 삭제 |
|---------|------|------|------|------|
| ArrayList | O(1) | O(n) | O(n) | O(n) |
| LinkedList | O(n) | O(n) | O(1) | O(1) |
| HashSet | - | O(1) | O(1) | O(1) |
| TreeSet | - | O(log n) | O(log n) | O(log n) |
| HashMap | - | O(1) | O(1) | O(1) |

---

## 연습 문제

1. **기본**: ArrayList에서 중복 요소 제거하기 (Set 활용)
2. **중급**: HashMap으로 문자열에서 각 문자의 빈도수 계산
3. **고급**: TreeSet으로 학생 성적 순위 시스템 구현
4. **응용**: Queue로 프린터 대기열 시뮬레이션

---

## 다음 단계

컬렉션 프레임워크 완성! 이제 실전 프로젝트에서 적절한 자료구조를 선택하여 효율적인 프로그램을 작성하세요.

**추가 학습 주제**:
- Stream API (Java 8+)
- 람다 표현식
- 함수형 프로그래밍
- 동시성 컬렉션 (ConcurrentHashMap 등)
