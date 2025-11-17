# ex03_nested - 중첩 클래스와 익명 클래스

> 중첩 클래스와 익명 클래스의 활용법을 학습합니다.

## 파일 구성

- `OuterClass.java` - 중첩 클래스 예제
- `AnonymousClassMain.java` - 익명 클래스 예제

## 중첩 클래스란?

클래스 안에 선언된 클래스입니다.

### 중첩 클래스의 종류

```
중첩 클래스 (Nested Class)
├── 정적 중첩 클래스 (Static Nested Class)
└── 내부 클래스 (Inner Class)
    ├── 멤버 내부 클래스 (Member Inner Class)
    ├── 로컬 내부 클래스 (Local Inner Class)
    └── 익명 내부 클래스 (Anonymous Inner Class)
```

## 1. 멤버 내부 클래스

외부 클래스의 인스턴스 멤버처럼 동작합니다.

```java
class OuterClass {
    private int outerField = 10;

    class InnerClass {
        void display() {
            // 외부 클래스의 private 멤버에 접근 가능
            System.out.println("외부 필드: " + outerField);
        }
    }

    void createInner() {
        InnerClass inner = new InnerClass();
        inner.display();
    }
}

// 사용
OuterClass outer = new OuterClass();
OuterClass.InnerClass inner = outer.new InnerClass();
```

**특징**:
- 외부 클래스의 모든 멤버(private 포함) 접근 가능
- 외부 클래스 인스턴스가 있어야 생성 가능
- static 멤버 선언 불가 (Java 16+ 가능)

## 2. 정적 중첩 클래스

외부 클래스의 static 멤버처럼 동작합니다.

```java
class OuterClass {
    private static int staticField = 20;
    private int instanceField = 30;

    static class StaticNestedClass {
        void display() {
            // static 멤버만 접근 가능
            System.out.println("정적 필드: " + staticField);
            // System.out.println(instanceField);  // 컴파일 에러!
        }
    }
}

// 사용
OuterClass.StaticNestedClass nested = new OuterClass.StaticNestedClass();
```

**특징**:
- 외부 클래스의 static 멤버만 접근 가능
- 외부 클래스 인스턴스 없이 생성 가능
- static 멤버 선언 가능

## 3. 로컬 내부 클래스

메서드 안에 선언된 클래스입니다.

```java
class OuterClass {
    void someMethod() {
        final int localVar = 40;

        class LocalInnerClass {
            void display() {
                System.out.println("로컬 변수: " + localVar);
            }
        }

        LocalInnerClass local = new LocalInnerClass();
        local.display();
    }
}
```

**특징**:
- 메서드 내에서만 사용 가능
- final 또는 effectively final 변수만 접근 가능

## 4. 익명 내부 클래스

이름이 없는 클래스로, 선언과 동시에 객체를 생성합니다.

### 인터페이스 구현
```java
interface Greeting {
    void sayHello();
}

public class AnonymousClassMain {
    public static void main(String[] args) {
        // 익명 클래스로 인터페이스 구현
        Greeting greeting = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("안녕하세요!");
            }
        };

        greeting.sayHello();
    }
}
```

### 추상 클래스 구현
```java
abstract class Animal {
    abstract void sound();
}

Animal dog = new Animal() {
    @Override
    void sound() {
        System.out.println("멍멍");
    }
};
```

### 클래스 상속
```java
class Button {
    void onClick() {
        System.out.println("버튼 클릭");
    }
}

Button submitButton = new Button() {
    @Override
    void onClick() {
        System.out.println("제출 버튼 클릭!");
    }
};
```

## 익명 클래스의 활용

### 1. 이벤트 핸들러
```java
button.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick() {
        System.out.println("버튼이 클릭되었습니다.");
    }
});
```

### 2. 정렬 (Comparator)
```java
List<String> names = Arrays.asList("Charlie", "Alice", "Bob");

Collections.sort(names, new Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
});
```

### 3. 스레드
```java
Thread thread = new Thread(new Runnable() {
    @Override
    public void run() {
        System.out.println("스레드 실행 중");
    }
});
thread.start();
```

## 람다식과의 관계 (Java 8+)

익명 클래스는 함수형 인터페이스의 경우 람다식으로 간결하게 표현 가능합니다.

### 익명 클래스
```java
Runnable r = new Runnable() {
    @Override
    public void run() {
        System.out.println("실행");
    }
};
```

### 람다식
```java
Runnable r = () -> System.out.println("실행");
```

## 중첩 클래스를 언제 사용할까?

### 멤버 내부 클래스
- 외부 클래스와 밀접한 관계
- 외부 클래스의 멤버에 자주 접근

### 정적 중첩 클래스
- 외부 클래스의 네임스페이스만 필요
- 외부 인스턴스 불필요

### 익명 클래스
- 일회성 구현
- 간단한 구현
- 이벤트 핸들러, 콜백

## 실행 방법

```bash
# 익명 클래스 예제
mvn exec:java -pl chap07 -Dexec.mainClass="com.chap07.ex03_nested.AnonymousClassMain"
```

## 장단점

### 장점
- **캡슐화**: 논리적으로 관련된 클래스를 그룹화
- **가독성**: 관련 코드를 한 곳에 모음
- **유지보수**: 클래스 간 관계가 명확

### 단점
- **복잡성**: 중첩이 깊어지면 가독성 저하
- **메모리**: 내부 클래스는 외부 클래스 참조 유지

## 실전 예제

### Builder 패턴
```java
public class User {
    private String name;
    private int age;

    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    // 정적 중첩 클래스로 Builder 구현
    public static class Builder {
        private String name;
        private int age;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

// 사용
User user = new User.Builder()
    .setName("John")
    .setAge(30)
    .build();
```

## 정리

| 종류 | 키워드 | 외부 멤버 접근 | 사용 시점 |
|------|--------|--------------|----------|
| 멤버 내부 | class | 모든 멤버 | 외부 인스턴스와 강한 관계 |
| 정적 중첩 | static class | static만 | 네임스페이스만 필요 |
| 로컬 내부 | class (메서드 내) | 메서드 변수 (final) | 메서드 내에서만 사용 |
| 익명 내부 | new 인터페이스() {} | 메서드 변수 (final) | 일회성 구현 |

## 다음 단계

Chapter 7 완료! **Chapter 08**에서 제네릭을 학습하여 타입 안전한 코드를 작성하세요.
