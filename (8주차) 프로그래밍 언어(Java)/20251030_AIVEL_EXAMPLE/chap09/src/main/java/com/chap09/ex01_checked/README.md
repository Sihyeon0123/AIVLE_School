# ex01_checked - Checked Exception

> 컴파일 시점에 체크되는 예외를 학습합니다.

## 파일 구성

1. `IOExceptionExample.java` - 파일 입출력 예외
2. `MalformedURLExceptionExample.java` - URL 형식 오류

## Checked Exception이란?

컴파일러가 **반드시 처리하도록 강제**하는 예외입니다.

### 특징
- 컴파일 시점에 체크
- 반드시 try-catch 또는 throws 필요
- 주로 외부 리소스 처리 시 발생
- `Exception` 클래스를 상속 (단, `RuntimeException` 제외)

### 대표적인 Checked Exception
- `IOException`: 입출력 오류
- `FileNotFoundException`: 파일을 찾을 수 없음
- `SQLException`: 데이터베이스 오류
- `ClassNotFoundException`: 클래스를 찾을 수 없음
- `MalformedURLException`: 잘못된 URL 형식

---

## 예제 1: IOExceptionExample.java - 파일 입출력 예외

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

### 발생 가능한 예외

1. **FileNotFoundException**: 파일이 존재하지 않음
   - `new FileReader("exemple.txt")` 시 발생

2. **IOException**: 파일 읽기/쓰기 중 오류
   - `readLine()` 시 발생 가능
   - `close()` 시 발생 가능

### 예외 계층 구조
```
IOException
└── FileNotFoundException
```

`FileNotFoundException`은 `IOException`의 하위 클래스이므로 **더 구체적인 예외를 먼저** catch해야 합니다.

### try-with-resources로 개선 (Java 7+)

```java
try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
} catch (FileNotFoundException e) {
    System.out.println("파일을 찾을 수 없습니다: " + e.getMessage());
} catch (IOException e) {
    System.out.println("파일 읽기 오류: " + e.getMessage());
}
// reader.close() 자동 호출!
```

**장점**:
- 리소스 자동 정리
- finally 블록 불필요
- 코드 간결화

**실행**:
```bash
mvn exec:java -pl chap09 -Dexec.mainClass="com.chap09.ex01_checked.IOExceptionExample"
```

---

## 예제 2: MalformedURLExceptionExample.java - URL 형식 오류

잘못된 URL 형식으로 인한 예외를 처리합니다.

```java
import java.net.MalformedURLException;
import java.net.URL;

public class MalformedURLExceptionExample {
    public static void main(String[] args) {
        try {
            // 잘못된 프로토콜 (htp 대신 http)
            URL url = new URL("htp://invalid-url");
            System.out.println("URL: " + url);
        } catch (MalformedURLException e) {
            System.out.println("잘못된 URL 형식: " + e.getMessage());
        }
    }
}
```

### 발생 원인

1. **잘못된 프로토콜**
   - `htp://` (http가 아님)
   - `htps://` (https가 아님)

2. **잘못된 URL 구조**
   - 공백이나 특수문자
   - 잘못된 포맷

### 올바른 URL 예시
```java
URL url1 = new URL("http://www.example.com");
URL url2 = new URL("https://www.example.com:8080/path");
URL url3 = new URL("ftp://ftp.example.com");
```

**실행**:
```bash
mvn exec:java -pl chap09 -Dexec.mainClass="com.chap09.ex01_checked.MalformedURLExceptionExample"
```

---

## Checked Exception 처리 방법

### 1. try-catch로 직접 처리
```java
public void readFile() {
    try {
        FileReader fr = new FileReader("file.txt");
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}
```

### 2. throws로 호출자에게 전파
```java
public void readFile() throws FileNotFoundException {
    FileReader fr = new FileReader("file.txt");
}

public void caller() {
    try {
        readFile();
    } catch (FileNotFoundException e) {
        // 여기서 처리
    }
}
```

### 3. 둘 다 사용
```java
public void processFile() throws IOException {
    try {
        FileReader fr = new FileReader("file.txt");
        // 처리
    } catch (FileNotFoundException e) {
        // FileNotFoundException만 여기서 처리
        System.out.println("파일 없음");
    }
    // IOException은 throws로 전파
}
```

## 언제 Checked Exception을 사용할까?

### 사용하는 경우
- **복구 가능한 상황**: 다른 파일 시도, 재연결 등
- **외부 리소스**: 파일, 네트워크, 데이터베이스
- **호출자가 알아야 하는 상황**: 메서드 시그니처에 명시

### 예시
```java
public User findUserById(Long id) throws UserNotFoundException {
    User user = database.query(id);
    if (user == null) {
        throw new UserNotFoundException("사용자를 찾을 수 없습니다: " + id);
    }
    return user;
}
```

## 베스트 프랙티스

### 1. 구체적인 예외 먼저 catch
```java
try {
    // ...
} catch (FileNotFoundException e) {  // 구체적
    // ...
} catch (IOException e) {            // 일반적
    // ...
}
```

### 2. 의미있는 메시지
```java
catch (IOException e) {
    throw new RuntimeException("파일 처리 실패: " + filename, e);
}
```

### 3. 리소스는 try-with-resources 사용
```java
try (FileInputStream fis = new FileInputStream("file.txt")) {
    // 사용
}
```

### 4. 예외 무시하지 않기
```java
// 나쁜 예
catch (IOException e) { }

// 좋은 예
catch (IOException e) {
    logger.error("파일 읽기 실패", e);
    // 또는 다른 예외로 래핑
}
```

## 정리

| 항목 | 설명 |
|------|------|
| **체크 시점** | 컴파일 타임 |
| **처리 강제** | 필수 (try-catch 또는 throws) |
| **상속** | `Exception` (RuntimeException 제외) |
| **발생 원인** | 외부 요인 (파일, 네트워크 등) |
| **목적** | 복구 가능한 상황 처리 |

## 다음 단계

**ex02_unchecked**에서 Unchecked Exception을 학습하고 차이점을 이해하세요.
