# ex03_shapes - 도형 상속 예제

> 도형 클래스를 통해 다단계 상속과 메서드 오버라이딩을 학습합니다.

## 파일 구성

- `Shape.java` - 전체 도형 클래스 (Shape, Circle, Ball, Cylinder, Cone)

## 계층 구조

```
Shape (도형)
└── Circle (원)
    ├── Ball (공)
    ├── Cylinder (원기둥)
    └── Cone (원뿔)
```

## 주요 클래스

### Shape - 기본 도형
```java
class Shape {
    double area() {
        return 0;
    }
}
```

### Circle - 원
- 속성: 반지름 (radius)
- 메서드: `area()` - 원의 넓이 (πr²)

### Ball - 공
- Circle 상속
- 속성: 반지름 (상속)
- 메서드: `area()` - 구의 표면적 (4πr²)

### Cylinder - 원기둥
- Circle 상속
- 속성: 반지름, 높이 (height)
- 메서드: `area()` - 원기둥 겉넓이 (2πr² + 2πrh)

### Cone - 원뿔
- Circle 상속
- 속성: 반지름, 높이 (height)
- 메서드: `area()` - 원뿔 겉넓이 (πr² + πrl)

## 실행 방법

```bash
mvn exec:java -pl chap06 -Dexec.mainClass="com.chap06.ex03_shapes.ShapeMain"
```

## 학습 포인트

1. **다단계 상속**: Circle → Ball, Cylinder, Cone
2. **메서드 오버라이딩**: 각 도형마다 다른 면적 계산
3. **수학적 관계의 코드 표현**

## 다음 단계

**ex04_access**에서 접근 제어자를 학습하세요.
