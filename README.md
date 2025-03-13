# kiosk-project

## 📌 프로젝트 개요
자바로 키오스크를 만들어 봅니다

자바의 기본 문법의 실습을 통해 

클래스의 개념을 이해하고 객체 지향 설계를 해보는 것이 목적입니다.
## 📁 프로젝트 구조
```
kiosk-project-dev/
├── src/
│   ├── lv1kiosk/
│   │   ├── Kiosk.java  # 메뉴와 입출력을 컨트롤
│   │   ├── Main.java  # LV1 메인 실행 파일
│   │   ├── Menu.java  # 만들어진 메뉴를 모아 컨트롤
│   │   ├── MenuItem.java  # 메뉴를 만드는 클래스
│   ├── lv2kiosk/
│   │   ├── Kiosk.java 
│   │   ├── Main.java  # LV2 메인 실행 파일
│   │   ├── Menu.java  
│   │   ├── MenuItem.java
│   ├── lv3kiosk/  # 미완성 입니다 display 구현중 lv5로 건너뜀
│   │   ├── Input.java  # 키오스크의 입력을 담당
│   │   ├── Kiosk.java  # input,display,menu를 컨트롤
│   │   ├── KioskDisplay.java  # 키오스크의 화면 구성을 담당
│   │   ├── Main.java  # LV3 메인 실행 파일
│   │   ├── Menu.java
│   │   ├── MenuItem.java
│   ├── lv5kiosk/
│   │   ├── Input.java  # 입력을 담당
│   │   ├── Kiosk.java  # 모든 클래스를 컨트롤
│   │   ├── KioskDisplay.java  # 출력을 담당
│   │   ├── Main.java  # LV5 단순하게 키오스크 실행 파일
│   │   ├── Menu.java  # 메뉴를 컨트롤
│   │   ├── MenuItem.java  # 메뉴를 만듬
│   │   ├── Payment.java # 결제 기능을 담당
├── .idea/  # IntelliJ 프로젝트 설정 파일
├── .gitignore  # Git에 포함하지 않을 파일 목록
├── KioskProject.iml  # IntelliJ 프로젝트 설정 파일
└── README.md  # 프로젝트 설명 파일
```

## 🚀 실행 방법
### 1. 프로젝트 클론
```sh
git clone <repository-url>
cd kiosk-project-dev
```

### 2. IDE에서 열기
IntelliJ IDEA에서 `File -> Open`을 선택한 후 `kiosk-project-dev` 디렉토리를 엽니다.

### 3. 실행
- `lv1kiosk.Main` 클래스 실행 (`lv1` 단계 실행)
- `lv2kiosk.Main` 클래스 실행 (`lv2` 단계 실행)
- `lv3kiosk.Main` 실행시 에러
- `lv5kiosk.Main` 클래스 실행 (`lv5` 단계 실행)

## 🛠️ 기술 스택
- **Java**: 키오스크 애플리케이션 구현
- **IntelliJ IDEA**: 개발 환경
- **Git**: 버전 관리를 위해 브랜치 사용
- **실행 방식:** 터미널 기반 실행

## 📌 주요 기능
| 단계 | 기능                |
|------|-------------------|
| lv1  | 기본 메뉴 시스템 및 주문 처리 |
| lv2  | 연산 기능 분리 (메뉴, 입력) |
| lv3  | 입-출력 기능 강화        |
| lv5  | 최종 기능 추가 및 최적화    |


## 📌 코드 구조 및 설계 패턴
### 결합도(Coupling)를 낮추는 설계 원칙
- **캡슐화 (Encapsulation)**: 클래스의 직접적인 접근을 제한

### 예외 처리 방식
- **잘못된 입력값 감지 및 재입력 요청**
- **리스트에 접근방식이 index번호라 NullPointerException에 주의를 기울임**
- **기존에 있는 NullPointer와 Illigal 예외를 직접 던진 구문이 있으니 주의**


## 📝 향후 개선 사항
- 키오스크의 로직 개선
- 장바구니를 구현
- 더욱 느슨한 상관관계를 가지기 위해 클래스 세분화
- 추상화와 상속을 통해 코드 가독성 확보
