# AIVLE Java 기초 강의 예제 프로젝트

> AIVLE Java 기초 강의를 위한 체계적인 예제 코드 모음

## 📚 프로젝트 개요

이 프로젝트는 Java 프로그래밍의 기초부터 고급 개념까지 단계별로 학습할 수 있도록 구성된 Maven 멀티모듈 프로젝트입니다.

## 🎯 학습 목표

- Java 기본 문법과 자료형 이해
- 객체지향 프로그래밍(OOP) 개념 습득
- 추상화와 인터페이스 활용
- 제네릭과 예외 처리 마스터
- 컬렉션 프레임워크 실전 활용

## 🗂️ 프로젝트 구조

```
20251030_AIVEL_EXAMPLE/
├── pom.xml                 # Parent POM (Maven 멀티모듈 설정)
├── README.md               # 이 파일
├── chap01/                 # Chapter 01: 기본 자료형
├── chap02/                 # Chapter 02: 연산자
├── chap03/                 # Chapter 03: 제어문
├── chap04/                 # Chapter 04: 반복문
├── chap05/                 # Chapter 05: 배열
├── chap06/                 # Chapter 06: 클래스와 상속
├── chap07/                 # Chapter 07: 추상화
├── chap08/                 # Chapter 08: 제네릭
├── chap09/                 # Chapter 09: 예외 처리
└── chap10/                 # Chapter 10: 컬렉션
```

## 📖 챕터별 상세 내용

### Chapter 01: 기본 자료형
- **파일 수**: 5개
- **주요 내용**: boolean, char, int, double 등 기본 자료형
- **예제**: `BooleanValues.java`, `IntegerValues.java`, `RealNumberValues.java`

### Chapter 02: 연산자
- **파일 수**: 12개
- **주요 내용**: 산술, 비교, 논리, 비트 연산자
- **예제**: 다양한 연산자 활용 예제

### Chapter 03: 제어문
- **파일 수**: 18개
- **주요 내용**: if-else, switch 문
- **예제**: 조건문을 활용한 프로그램 제어

### Chapter 04: 반복문
- **파일 수**: 20개
- **주요 내용**: for, while, do-while 반복문
- **예제**: 다양한 반복문 패턴

### Chapter 05: 배열
- **파일 수**: 13개
- **주요 내용**: 1차원/2차원 배열, 배열 조작
- **예제**: 배열 선언, 초기화, 활용

### Chapter 06: 클래스와 상속 ⭐
- **파일 수**: 18개
- **서브패키지**: 9개 (ex01~ex09)
- **주요 내용**:
  - `ex01_class_basics`: 클래스 기초
  - `ex02_inheritance`: 상속 개념
  - `ex03_overriding`: 메서드 오버라이딩
  - `ex04_constructor`: 생성자
  - `ex05_access`: 접근 제어자
  - `ex06_final`: final 키워드
  - `ex07_typecast`: 타입 캐스팅
  - `ex08_polymorphism`: 다형성
  - `ex09_utils`: import 실습

### Chapter 07: 추상화 ⭐
- **파일 수**: 15개
- **서브패키지**: 3개 (ex01~ex03)
- **주요 내용**:
  - `ex01_abstraction`: 추상 클래스
  - `ex02_interface`: 인터페이스, 디폴트 메서드, 다형성
  - `ex03_nested`: 중첩 클래스, 익명 클래스

### Chapter 08: 제네릭 ⭐
- **파일 수**: 5개
- **서브패키지**: 1개 (ex01)
- **주요 내용**:
  - `ex01_generics`: 제네릭 클래스, 인터페이스, 메서드, 와일드카드

### Chapter 09: 예외 처리 ⭐
- **파일 수**: 13개
- **서브패키지**: 2개 (ex01~ex02)
- **주요 내용**:
  - `ex01_checked`: Checked Exception (IOException, MalformedURLException)
  - `ex02_unchecked`: Unchecked Exception (NullPointer, ArrayIndexOutOfBounds 등)

### Chapter 10: 컬렉션
- **파일 수**: 10개
- **주요 내용**: ArrayList, LinkedList, HashSet, TreeSet, HashMap, Queue
- **예제**: 컬렉션 프레임워크 실전 활용

> ⭐ 표시는 서브패키지로 체계적으로 구조화된 챕터입니다.

## 🚀 시작하기

### 사전 요구사항

- **Java**: JDK 17 이상
- **Maven**: 3.6 이상
- **IDE**: IntelliJ IDEA (권장) 또는 Eclipse

### 옵션 1: 기존 프로젝트 클론하기 (권장)

#### GitHub에서 클론

```bash
git clone https://github.com/frentis-ai-study/aivle-school-java.git
cd aivle-school-java
```

#### IntelliJ에서 프로젝트 열기

```
1. File → Open
2. 루트 폴더의 pom.xml 파일 선택
3. "Open as Project" 선택
4. "Trust Project" 클릭
```

IntelliJ가 자동으로 Maven 멀티모듈 프로젝트를 인식하고 모든 챕터를 import합니다.

#### Eclipse에서 프로젝트 열기

```
1. File → Import → Maven → Existing Maven Projects
2. Root Directory에서 프로젝트 폴더 선택
3. Finish
```

### 옵션 2: 새 프로젝트 만들기 (처음부터 시작)

완전히 빈 상태에서 시작하는 방법입니다.

#### 1단계: IntelliJ에서 빈 Maven 프로젝트 생성

1. **File → New → Project**

2. **프로젝트 설정**
   ```
   Name: aivle-school-java
   Location: 원하는 경로 선택
   Language: Java
   Build system: Maven
   JDK: 17 이상 선택

   Advanced Settings:
   GroupId: com.aivle
   ArtifactId: aivle-school-java
   Version: 1.0
   ```

3. **Create** 클릭

**✅ 일반 Maven 프로젝트가 생성됩니다**

#### 2단계: 첫 번째 모듈 추가하면서 Parent로 변환

> 💡 **핵심**: 첫 모듈을 추가할 때 **"Add as module to" 옵션에서 Parent 선택**하면 자동으로 Parent POM으로 변환됩니다!

1. **프로젝트 루트에서 우클릭 → New → Module**

2. **Maven 모듈 설정**
   ```
   Name: chap01

   ⭐ Add as module to: (현재 프로젝트 선택) - 이게 핵심!

   GroupId: com.aivle
   ArtifactId: chap01
   ```

3. **Create** 클릭

**✨ IntelliJ가 자동으로 처리**:
- ✅ 루트 pom.xml을 `packaging=pom`으로 자동 변환
- ✅ `<modules>` 섹션 자동 추가
- ✅ chap01 폴더 및 pom.xml 생성
- ✅ src/main/java 구조 생성

#### 3단계: 패키지 및 클래스 생성

1. **패키지 생성**: `chap01/src/main/java` 우클릭 → New → Package → `com.chap01`

2. **클래스 생성**: `com.chap01` 우클릭 → New → Java Class → `Hello`

3. **코드 작성**
   ```java
   package com.chap01;

   public class Hello {
       public static void main(String[] args) {
           System.out.println("Hello, AIVLE Java!");
       }
   }
   ```

4. **실행**: main 메서드 옆 ▶️ 클릭 → Run

#### 4단계: 나머지 챕터 모듈 추가

위의 2~3단계를 반복하여 chap02, chap03, ... chap10까지 생성합니다.

#### 🎯 완료!

이제 멀티모듈 프로젝트가 다음과 같은 구조로 만들어졌습니다:

```
aivle-school-java/
├── pom.xml (Parent POM)
├── chap01/
│   ├── pom.xml
│   └── src/main/java/com/chap01/
│       └── Hello.java
├── chap02/
├── chap03/
└── ...
```

### 빌드 및 컴파일

전체 프로젝트 빌드:
```bash
mvn clean compile
```

특정 챕터만 빌드:
```bash
cd chap06
mvn clean compile
```

## 💻 예제 실행하기

### IntelliJ에서 실행

1. 프로젝트 탐색기에서 실행하고 싶은 Main 클래스 찾기
2. 파일 내에서 `public static void main` 옆의 ▶️ 버튼 클릭
3. 또는 파일에서 우클릭 → Run

### 명령줄에서 실행

```bash
# Chapter 6 - 상속 예제 실행
mvn exec:java -pl chap06 -Dexec.mainClass="com.chap06.ex02_inheritance.Animal"

# Chapter 6 - 생성자 예제 실행
mvn exec:java -pl chap06 -Dexec.mainClass="com.chap06.ex04_constructor.InheritanceConstructorMain"

# Chapter 6 - 다형성 예제 실행
mvn exec:java -pl chap06 -Dexec.mainClass="com.chap06.ex08_polymorphism.TypeCastPolymorphismMain"

# Chapter 7 - 추상 클래스 예제 실행
mvn exec:java -pl chap07 -Dexec.mainClass="com.chap07.ex01_abstraction.AbstractMain"

# Chapter 9 - 예외 처리 예제 실행
mvn exec:java -pl chap09 -Dexec.mainClass="com.chap09.ex02_unchecked.NullPointerExceptionExample"
```

## 🎨 IntelliJ IDEA 실습 가이드

### 프로젝트 구조 이해하기

IntelliJ에서 프로젝트를 열면 다음과 같은 구조가 보입니다:

```
Project View (⌘1 또는 Alt+1)
├── 📁 20251030_AIVEL_EXAMPLE (Root)
│   ├── 📁 chap01
│   │   ├── 📁 src/main/java/com/chap01
│   │   └── 📄 pom.xml
│   ├── 📁 chap06
│   │   ├── 📁 src/main/java/com/chap06
│   │   │   ├── 📁 ex01_class_basics
│   │   │   ├── 📁 ex02_inheritance
│   │   │   └── ...
│   │   └── 📄 pom.xml
│   └── 📄 pom.xml (Parent POM)
```

### 1️⃣ 새로운 챕터 모듈 추가하기

> 💡 **IntelliJ UI를 사용하면 서브 모듈이 자동으로 Parent POM에 추가됩니다!**

1. **프로젝트 루트에서 우클릭 → New → Module**

2. **Maven 모듈 설정**
   ```
   Name: chap11
   Parent: com.aivle:aivle-school-java:1.0 (자동 선택됨)
   ```

3. **Create 클릭**

**✨ IntelliJ가 자동으로 처리**:
- ✅ 모듈 폴더 및 pom.xml 생성
- ✅ Parent POM의 `<modules>`에 자동 추가
- ✅ src/main/java 구조 생성

### 2️⃣ 새로운 패키지 및 클래스 만들기

#### 패키지 생성

1. **src/main/java/com/chapXX 우클릭**
   ```
   New → Package
   ```

2. **패키지 이름 입력**
   ```
   예: ex01_basics
   ```
   - IntelliJ가 자동으로 `com.chapXX.ex01_basics` 경로 생성

#### Java 클래스 생성

1. **패키지에서 우클릭**
   ```
   New → Java Class
   ```

2. **클래스 정보 입력**
   ```
   Name: MyExample
   Kind: Class (기본값)
   ```

3. **자동 생성되는 코드**
   ```java
   package com.chapXX.ex01_basics;

   public class MyExample {
   }
   ```

4. **main 메서드 빠르게 추가**
   ```
   클래스 내부에서 "psvm" 타이핑 후 Tab
   → public static void main(String[] args) 자동 생성
   ```

### 3️⃣ 코드 작성 및 실행

#### Live Templates (코드 스니펫)

IntelliJ에서 자주 사용하는 단축키:

| 단축키 | 설명 | 결과 |
|--------|------|------|
| `psvm` + Tab | main 메서드 생성 | `public static void main(String[] args) {}` |
| `sout` + Tab | println 생성 | `System.out.println();` |
| `fori` + Tab | for 반복문 생성 | `for (int i = 0; i < ; i++) {}` |
| `iter` + Tab | foreach 생성 | `for (String s : ) {}` |

#### 코드 실행 방법

**방법 1: Gutter 아이콘 사용**
```
main 메서드 옆 초록색 ▶️ 클릭 → Run
```

**방법 2: 컨텍스트 메뉴**
```
파일 편집기에서 우클릭 → Run 'ClassName.main()'
```

**방법 3: 단축키**
```
⌃⇧R (Mac) / Ctrl+Shift+F10 (Windows/Linux)
```

**방법 4: 상단 툴바**
```
Run 메뉴 → Run... → 실행할 클래스 선택
```

### 4️⃣ 디버깅

#### 브레이크포인트 설정

1. **코드 라인 번호 옆 클릭**
   - 빨간 점(●)이 생기면 브레이크포인트 설정됨

2. **디버그 모드 실행**
   ```
   main 메서드 옆 ▶️ 우클릭 → Debug
   또는 ⌃⇧D (Mac) / Ctrl+Shift+F9 (Windows)
   ```

#### 디버깅 컨트롤

| 단축키 | 기능 | 설명 |
|--------|------|------|
| F8 | Step Over | 다음 라인으로 이동 |
| F7 | Step Into | 메서드 내부로 진입 |
| Shift+F8 | Step Out | 메서드에서 빠져나옴 |
| F9 | Resume | 다음 브레이크포인트까지 실행 |

#### Variables 창 활용

디버깅 중 하단 Variables 탭에서:
- 현재 변수 값 확인
- 변수 우클릭 → Set Value로 값 변경 가능
- Watches 추가로 표현식 모니터링

### 5️⃣ 유용한 단축키 모음

#### 코드 네비게이션

| 단축키 (Mac) | 단축키 (Win/Linux) | 기능 |
|-------------|-------------------|------|
| ⌘O | Ctrl+N | 클래스 검색 |
| ⌘⇧O | Ctrl+Shift+N | 파일 검색 |
| ⌘B | Ctrl+B | 선언부로 이동 |
| ⌘⌥B | Ctrl+Alt+B | 구현부로 이동 |
| ⌘[ / ⌘] | Ctrl+Alt+← / → | 이전/다음 위치 |

#### 코드 편집

| 단축키 (Mac) | 단축키 (Win/Linux) | 기능 |
|-------------|-------------------|------|
| ⌘D | Ctrl+D | 라인 복제 |
| ⌘⌫ | Ctrl+Y | 라인 삭제 |
| ⌥⇧↑/↓ | Alt+Shift+↑/↓ | 라인 이동 |
| ⌘⌥L | Ctrl+Alt+L | 코드 포맷팅 |
| ⌃Space | Ctrl+Space | 코드 자동완성 |

#### 리팩토링

| 단축키 (Mac) | 단축키 (Win/Linux) | 기능 |
|-------------|-------------------|------|
| ⇧F6 | Shift+F6 | 이름 변경 (Rename) |
| ⌘⌥M | Ctrl+Alt+M | 메서드 추출 |
| ⌘⌥V | Ctrl+Alt+V | 변수 추출 |
| ⌘⌥C | Ctrl+Alt+C | 상수 추출 |

### 6️⃣ Maven 통합

#### Maven 프로젝트 리로드

```
View → Tool Windows → Maven (우측 탭)
→ Reload All Maven Projects (🔄 아이콘)
```

또는 **pom.xml에서 변경 후 우측 상단 알림**에서 "Import Changes" 클릭

#### Maven 골 실행

```
Maven 탭 → 프로젝트 확장 → Lifecycle
→ clean, compile, test, package 더블클릭으로 실행
```

#### 특정 모듈만 빌드

```
Maven 탭 → chap06 → Lifecycle → compile 더블클릭
```

### 7️⃣ 코드 스타일 및 포맷팅

#### 자동 포맷팅 설정

```
Preferences (⌘,) → Editor → Code Style → Java
→ Scheme: Default 또는 커스텀 설정
```

#### 저장 시 자동 포맷팅

```
Preferences → Tools → Actions on Save
→ ✅ Reformat code
→ ✅ Optimize imports
```

#### 코드 포맷팅 실행

```
⌘⌥L (Mac) / Ctrl+Alt+L (Windows/Linux)
```

### 8️⃣ 문제 해결

#### 클래스 인식 안 될 때

```
1. File → Invalidate Caches / Restart → Invalidate and Restart
2. Maven 탭 → Reload All Maven Projects
3. Project Structure (⌘;) → Modules 확인
```

#### 컴파일 에러 발생 시

```
1. Project Structure (⌘;) → Project
   → Project SDK: Java 17 이상 확인
2. Project Structure → Modules → chap06 → Sources
   → src/main/java가 Sources로 마크되었는지 확인
```

#### Maven 의존성 문제

```
1. .m2 캐시 삭제:
   ~/.m2/repository 폴더 삭제 (Mac/Linux)
   C:\Users\사용자명\.m2\repository 폴더 삭제 (Windows)

2. IntelliJ에서 Maven Reimport:
   Maven 탭 → Reload All Maven Projects
```

### 9️⃣ 실습 워크플로우 예시

**새로운 예제 만들기**:
1. 패키지 생성 (`New → Package`)
2. 클래스 생성 (`New → Java Class`)
3. 코드 작성 (`psvm`, `sout` 활용)
4. 실행 (▶️ 클릭)
5. 디버깅 (필요시)

### 🔟 추가 팁

#### 코드 자동 생성 (Generate)

```
Alt+Insert (Mac: ⌘N) 후:
- Constructor: 생성자 자동 생성
- Getter/Setter: getter/setter 자동 생성
- equals() and hashCode(): 비교 메서드 생성
- toString(): 문자열 표현 메서드 생성
```

#### Multi-cursor 편집

```
Alt+클릭: 여러 커서 추가
Ctrl+G (Mac: ⌘G): 선택한 단어와 동일한 다음 단어 선택
Ctrl+Shift+Alt+J: 선택한 단어와 동일한 모든 단어 선택
```

#### 빠른 문서 확인

```
메서드나 클래스 위에 커서 → F1 (Mac: ⌘J)
→ JavaDoc 팝업으로 문서 확인
```

## 📝 학습 가이드

### 권장 학습 순서

1. **Chapter 01-05**: Java 기본 문법 숙지
2. **Chapter 06**: 객체지향의 핵심인 상속 개념 이해
3. **Chapter 07**: 추상화와 인터페이스로 설계 능력 향상
4. **Chapter 08**: 제네릭으로 타입 안전성 확보
5. **Chapter 09**: 예외 처리로 안정적인 프로그램 작성
6. **Chapter 10**: 컬렉션으로 효율적인 데이터 관리

### 학습 팁

- 각 챕터의 예제를 **직접 실행**해보며 결과를 확인하세요
- 코드를 **수정**해보며 동작 원리를 이해하세요
- **주석**을 읽으며 코드의 의도를 파악하세요
- 각 챕터의 README를 참고하여 **체계적으로** 학습하세요

## 🎓 주요 개념 정리

### 객체지향 4대 원칙 (OOP)
- **캡슐화** (Encapsulation): Chapter 06 - ex04_access
- **상속** (Inheritance): Chapter 06 - ex01_basics, ex05_inheritance
- **다형성** (Polymorphism): Chapter 06 - ex06_polymorphism
- **추상화** (Abstraction): Chapter 07 - ex01_abstraction, ex02_interface

### 주요 Java 개념
- **추상 클래스 vs 인터페이스**: Chapter 07
- **제네릭**: Chapter 08
- **예외 처리 (Checked vs Unchecked)**: Chapter 09
- **컬렉션 프레임워크**: Chapter 10

## 📂 패키지 명명 규칙

서브패키지가 있는 챕터는 다음과 같은 명명 규칙을 따릅니다:

```
ex01_<주제명>/    # 예: ex01_basics, ex01_abstraction
ex02_<주제명>/    # 예: ex02_animals, ex02_interface
ex03_<주제명>/    # 예: ex03_shapes, ex03_nested
...
```

- `ex##`: 교재 순서를 나타내는 번호
- `<주제명>`: 해당 예제의 주제를 나타내는 의미있는 이름

## 🛠️ 기술 스택

- **언어**: Java 17
- **빌드 도구**: Maven 3.9.11
- **인코딩**: UTF-8
- **컴파일 옵션**:
  - Source: Java 17
  - Target: Java 17

## 📊 프로젝트 통계

| 항목 | 개수 |
|------|------|
| 총 챕터 수 | 10개 |
| 총 Java 파일 수 | 129개 |
| 서브패키지가 있는 챕터 | 4개 (chap06, 07, 08, 09) |
| 총 서브패키지 수 | 15개 |
| 코드 이미지 | 258개 (D2Coding + Nanum 2종) |

## 🐛 문제 해결

### Maven 빌드 실패 시
```bash
# Maven 캐시 정리 후 재빌드
mvn clean install -U
```

### IntelliJ에서 패키지 인식 안 될 때
```
1. File → Invalidate Caches / Restart
2. Maven 프로젝트 리로드: Maven 탭 → Reload All Maven Projects
```

### 컴파일 에러 발생 시
- JDK 버전이 17 이상인지 확인
- Project Structure (⌘;)에서 SDK 설정 확인
- Maven Compiler Plugin 설정 확인

## 🤔 멀티모듈 vs 일반 프로젝트 차이

### 왜 멀티모듈 프로젝트를 사용하나요?

이 프로젝트는 10개의 챕터로 구성되어 있습니다. 이를 **멀티모듈**로 관리하는 것과 **개별 프로젝트**로 관리하는 것의 차이는 다음과 같습니다:

### 비교표

| 항목 | 멀티모듈 프로젝트 (권장) ✅ | 개별 프로젝트 ❌ |
|------|------------------------|---------------|
| **프로젝트 구조** | 하나의 루트 + 10개 모듈 | 10개의 독립 프로젝트 |
| **IntelliJ 창** | 1개 창에서 모든 챕터 | 10개 창 열어야 함 |
| **빌드** | `mvn clean compile` 한 번 | 각 프로젝트마다 빌드 |
| **의존성 관리** | Parent POM에서 중앙 관리 | 각 프로젝트마다 설정 |
| **Java 버전 변경** | Parent POM 1곳만 수정 | 10개 pom.xml 수정 |
| **코드 검색** | 전체 프로젝트에서 검색 | 각 프로젝트마다 검색 |
| **파일 이동** | 쉽게 이동 가능 | 프로젝트 간 복사 필요 |
| **Git 관리** | 하나의 레포지토리 | 10개 레포지토리 또는 복잡한 구조 |

### 실제 사용 시나리오

#### 시나리오 1: 전체 프로젝트 빌드

**멀티모듈 프로젝트**:
```bash
cd aivle-school-java
mvn clean compile  # 모든 챕터 한 번에 빌드!
```

**개별 프로젝트**:
```bash
cd chap01 && mvn clean compile
cd ../chap02 && mvn clean compile
cd ../chap03 && mvn clean compile
# ... 10번 반복
```

#### 시나리오 2: Java 버전 업그레이드 (17 → 21)

**멀티모듈 프로젝트**:
```xml
<!-- 루트 pom.xml 1곳만 수정 -->
<maven.compiler.source>21</maven.compiler.source>
<maven.compiler.target>21</maven.compiler.target>
```

**개별 프로젝트**:
```bash
# 10개 pom.xml 파일을 각각 열어서 수정해야 함
```

#### 시나리오 3: IntelliJ에서 작업

**멀티모듈 프로젝트**:
- 하나의 IntelliJ 창에서 모든 챕터 볼 수 있음
- chap01에서 chap06으로 쉽게 이동
- 전체 프로젝트에서 "Animal" 클래스 검색 가능

**개별 프로젝트**:
- 10개의 IntelliJ 창을 열어야 함
- 챕터 간 이동 시 창 전환 필요
- 각 프로젝트에서 따로 검색해야 함

#### 시나리오 4: 공통 라이브러리 추가 (예: Lombok)

**멀티모듈 프로젝트**:
```xml
<!-- 루트 pom.xml의 <dependencyManagement>에 한 번만 추가 -->
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.30</version>
        </dependency>
    </dependencies>
</dependencyManagement>
```

**개별 프로젝트**:
```bash
# 10개 pom.xml에 각각 추가해야 함
```

### 프로젝트 구조 비교

#### 멀티모듈 프로젝트
```
aivle-school-java/
├── pom.xml (Parent POM - 공통 설정)
├── chap01/
│   └── pom.xml (Parent 상속)
├── chap02/
│   └── pom.xml (Parent 상속)
└── ...

✅ 하나의 루트 폴더
✅ 공통 설정 상속
✅ 일관된 구조
```

#### 개별 프로젝트
```
workspace/
├── java-chap01/
│   └── pom.xml (독립)
├── java-chap02/
│   └── pom.xml (독립)
└── ...

❌ 여러 루트 폴더
❌ 각자 설정
❌ 관리 복잡
```

### 결론

**멀티모듈을 사용하지 않으면**:
- ❌ 10개 프로젝트를 각각 관리해야 함
- ❌ IntelliJ에서 10개 창을 열어야 함
- ❌ 공통 설정을 10번 반복해야 함
- ❌ 빌드를 10번 실행해야 함
- ❌ 코드 검색이 번거로움

**멀티모듈을 사용하면**:
- ✅ 하나의 프로젝트처럼 관리
- ✅ IntelliJ 1개 창에서 모든 챕터 접근
- ✅ 공통 설정 1곳에서 관리
- ✅ 빌드 1번으로 모든 챕터 컴파일
- ✅ 전체 코드베이스 검색 가능

**👉 교육용 프로젝트에서 멀티모듈은 거의 필수입니다!**

## ❓ 자주 묻는 질문 (FAQ)

### Q1. 일반 프로젝트로 만들었는데 서브 모듈이 추가되지 않아요!

**A:** 첫 번째 모듈을 추가할 때 **"Add as module to" 옵션에서 현재 프로젝트를 선택**해야 자동으로 Parent POM으로 변환됩니다.

**해결**:
- **방법 1**: 모듈 추가 시 "Add as module to" 옵션 활용
- **방법 2**: 수동으로 루트 `pom.xml`에 `<packaging>pom</packaging>`과 `<modules></modules>` 추가 후 Maven 리로드

### Q2. 서브 모듈을 매번 Parent POM에 추가해야 하나요?

**A:** 아니요! Parent 프로젝트에서 IntelliJ의 `New → Module`로 만들면 **자동으로 추가**됩니다.

### Q3. Parent POM의 `<modules>` 순서가 중요한가요?

**A:** 의존성이 없으면 순서는 중요하지 않습니다. 이 프로젝트는 각 챕터가 독립적이므로 순서는 상관없습니다.

### Q4. 모듈이 인식되지 않으면?

**A:** Maven 리로드 (`Maven 탭 → Reload All Maven Projects`)를 실행하거나, IntelliJ 캐시 삭제 (`File → Invalidate Caches / Restart`)를 시도하세요.

## 📚 추가 자료

- [Java 17 Documentation](https://docs.oracle.com/en/java/javase/17/)
- [Maven Documentation](https://maven.apache.org/guides/)
- [Maven Multi-Module Projects](https://maven.apache.org/guides/mini/guide-multiple-modules.html)
- [IntelliJ IDEA Guide](https://www.jetbrains.com/idea/guide/)

## 👥 기여하기

이 프로젝트는 AIVLE 교육용 프로젝트입니다.
개선 사항이나 버그 발견 시 이슈를 등록해주세요.

## 📄 라이선스

이 프로젝트는 교육용으로 제작되었습니다.

---

**Happy Coding! 🚀**

*AIVLE - AI & VLE 교육센터*
