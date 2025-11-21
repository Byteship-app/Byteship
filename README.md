# Byteship - Battleship Network Game

![배너 이미지 또는 로고](링크)

> Java Socket + Swing 기반의 1:1 온라인 배틀쉽 네트워크 게임

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![JDK](https://img.shields.io/badge/JDK-17-blue.svg)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![License](https://img.shields.io/badge/license-MIT-green.svg)]()

---

<br>

## 멤버

| 팀원 1 | 팀원 2 |
|:------:|:------:|
| 사진1 | 사진2 |
| 서버 개발 | 클라이언트 개발 |
| [GitHub](깃허브 링크) | [GitHub](깃허브 링크) |

**역할 분담**
- **팀원 1 (재원)**: 서버 전체(소켓, 도메인, 서비스, 컨트롤러, 어드민 UI), 통신 프로토콜/메시지 구조 설계, 게임 로직 및 턴/READY/시작 조건 설계, 공통 Message/Mode 설계
- **팀원 2**: 클라이언트 전체(Swing UI, MVC, 클라 네트워크), Login/Lobby/Room/Game 화면 구현, 클라이언트 Listener 및 컨트롤러 구현

<br>

## 소개

> Java Socket을 이용한 다중 클라이언트 서버 기반의 배틀쉽 네트워크 게임입니다. 로비에서 방을 생성하거나 입장하여 다른 플레이어와 1:1 턴 기반 배틀쉽 게임을 즐길 수 있습니다.

**주요 특징**
- 단일 서버 - 다중 클라이언트 구조
- Object Stream 기반 직렬화 메시지 통신
- 로비 → 방 → 게임으로 이어지는 상태 전환
- 멀티스레드 기반 서버 (클라이언트별 스레드, 상태 관리)
- Swing UI 기반 클라이언트 (MVC 구조)
- 방 단위 채팅 기능
- 서버 Admin UI (모니터링/디버깅용)

<br>

## 프로젝트 기간

- 전체 기간: `YYYY.MM.DD - YYYY.MM.DD`
- 개발 기간: `YYYY.MM.DD - YYYY.MM.DD`

<br>

## 요구사항

For building and running the application you need:

- JDK 17 이상
- Java 개발 환경 (IntelliJ IDEA)
- 로컬 네트워크 환경 (서버와 클라이언트 간 통신)

<br>

## 개발 환경

* 언어: Java
* UI 프레임워크: Swing
* 네트워크: Java Socket (ServerSocket, Socket)
* 통신 방식: ObjectInputStream / ObjectOutputStream
* 버전 및 이슈 관리: Github
* 협업 툴: Discord, Notion

<br>

## 기술 스택

### Environment

<div align="left">

<img src="https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white" />

<img src="https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white" />

<img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />

<img src="https://img.shields.io/badge/JDK-17-ED8B00?style=for-the-badge&logo=java&logoColor=white" />

</div>

### Development

<div align="left">

<img src="https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white" />

<img src="https://img.shields.io/badge/Java_Socket-ED8B00?style=for-the-badge&logo=java&logoColor=white" />

<img src="https://img.shields.io/badge/Java_Swing-ED8B00?style=for-the-badge&logo=java&logoColor=white" />

<img src="https://img.shields.io/badge/Multithreading-ED8B00?style=for-the-badge&logo=java&logoColor=white" />

</div>

### Communication

<div align="left">

<img src="https://img.shields.io/badge/Notion-white.svg?style=for-the-badge&logo=Notion&logoColor=000000" />

<img src="https://img.shields.io/badge/Discord-5865F2?style=for-the-badge&logo=Discord&logoColor=white" />

</div>

<br>

## 화면 구성

<table>
  <tr>
    <td>
      로그인 화면
    </td>
    <td>
      로비 화면
    </td>
  </tr>
  <tr>
    <td>
      방 화면
    </td>
    <td>
      게임 화면
    </td>
  </tr>
</table>

<br>

## 실행 방법

### 서버 실행

1. `src/com/hsu/byteship/server/controller/core/Server.java`의 `main()` 메서드를 실행합니다.
2. 서버가 시작되면 지정된 포트(기본값: `server.txt` 참조)에서 클라이언트 접속을 대기합니다.
3. 서버 Admin UI가 자동으로 열려 현재 접속 클라이언트, 방 목록, 로그를 모니터링할 수 있습니다.

### 클라이언트 실행

1. 프로젝트 루트의 `server.txt` 파일에 서버 IP 주소와 포트 번호가 올바르게 설정되어 있는지 확인합니다.
   ```
   127.0.0.1
   54321
   ```
2. `src/com/hsu/byteship/client/view/login/LoginView.java` 또는 클라이언트 진입점을 실행합니다.
3. 로그인 화면에서 닉네임을 입력하고 로비에 입장합니다.
4. 로비에서 방을 생성하거나 기존 방에 입장할 수 있습니다.

<br>

## 프로젝트 구조

```
Byteship/
├─ common/                              # 서버·클라 공통으로 사용하는 공유 모델/메시지
│  ├─ message/
│  │  ├─ Message.java                   # 직렬화용 공통 메시지 DTO
│  │  └─ Mode.java                      # 통신 상태/기능을 나타내는 enum
│  └─ model/
│     └─ Coordinate.java                # 배틀쉽 좌표(x,y) 표현용 Value Object
│
├─ server/                              # 서버 전체
│  ├─ controller/                       # 컨트롤러 계층
│  │  ├─ core/                          # 서버 코어 (Server, ClientHandler, MessageDispatcher)
│  │  ├─ lobby/                         # 로비 컨트롤러
│  │  ├─ room/                          # 방 컨트롤러
│  │  ├─ game/                          # 게임 컨트롤러
│  │  └─ chat/                          # 채팅 컨트롤러
│  ├─ service/                          # 비즈니스 로직 계층
│  ├─ model/                            # 서버 도메인 모델
│  ├─ view/                             # 서버 어드민용 Swing UI
│  └─ util/                             # 서버 유틸리티
│
└─ client/                              # 클라이언트 전체
   ├─ controller/                       # 클라이언트 컨트롤러
   ├─ view/                             # Swing UI 화면
   ├─ model/                            # 클라이언트 모델
   ├─ config/                           # 설정 파일 로더
   └─ util/                             # 클라이언트 유틸리티
```

<br>

## 게임 규칙

1. 방에는 최대 2명의 플레이어가 입장할 수 있습니다.
2. 첫 번째 입장자는 **방장(Host)**, 두 번째 입장자는 **참가자(Player)** 역할을 가집니다.
3. 참가자는 방 화면에서 **READY 버튼**을 눌러 준비 상태가 될 수 있습니다.
4. **두 플레이어 모두 READY 상태일 때만 방장이 게임을 시작할 수 있습니다.**
5. 게임은 **턴 기반**으로 진행되며, 각 턴마다 하나의 좌표에 공격을 수행합니다.
6. 공격 결과는 HIT, MISS, DESTROYED 등으로 판정됩니다.
7. 한쪽의 모든 배가 격침되면 게임이 종료되고 승패가 결정됩니다.
8. 게임 종료 후 플레이어는 다시 로비로 돌아갑니다.

<br>

## 브랜치 컨벤션

### 브랜치 전략: GitHub Flow

- **main**: 프로덕션 배포 가능한 안정적인 코드
- **feature/000**: 새로운 기능 개발
- **fix/000**: 버그 수정
- **chore/000**: 빌드/설정 관련 작업
- **refactor/000**: 코드 리팩토링
- **docs/000**: 문서 작업

### 브랜치 네이밍 규칙

```
{타입}/{간단한-설명}
```

**예시:**
- `feature/room-creation`
- `fix/login-error`
- `chore/project-settings`
- `refactor/message-handler`
- `docs/readme-update`

### GitHub Flow 워크플로우

1. `main`에서 브랜치 생성 (`feature/xxx`)
2. 작업 후 커밋
3. GitHub에 푸시
4. Pull Request 생성
5. 리뷰 후 `main`에 머지
6. 브랜치 삭제

<br>

## 코딩 컨벤션

### 네이밍 컨벤션

**클래스/인터페이스**
- 파스칼 케이스 (PascalCase)
- 명사 사용
- 예: `Server`, `ClientHandler`, `MessageDispatcher`

**메서드**
- 카멜 케이스 (camelCase)
- 동사로 시작
- 예: `createRoom()`, `handleMessage()`, `sendAttack()`

**변수**
- 카멜 케이스 (camelCase)
- 명사 사용
- 예: `playerName`, `roomId`, `currentTurn`

**상수**
- 대문자 + 언더스코어 (UPPER_SNAKE_CASE)
- 예: `MAX_PLAYERS`, `DEFAULT_PORT`, `GAME_BOARD_SIZE`

**패키지**
- 소문자만 사용, 언더스코어 지양
- 예: `com.hsu.byteship.server.controller`

**Enum**
- 클래스명은 파스칼 케이스, 값은 대문자 + 언더스코어
- 예: `enum Mode { ENTER_LOBBY, GAME_START }`

### 코드 포맷팅

**들여쓰기**
- 4칸 스페이스 (탭 사용 지양)

**중괄호**
- K&R 스타일 (열리는 괄호는 같은 줄)
```java
if (condition) {
    // code
}
```

**빈 줄**
- 클래스/메서드 사이 1줄
- 논리적 블록 구분에 사용

### 클래스 구조 순서

```java
public class Example {
    // 1. 상수
    private static final int CONSTANT = 10;
    
    // 2. 필드 (static → instance, public → private)
    private static int staticField;
    private int instanceField;
    
    // 3. 생성자
    public Example() { }
    
    // 4. 메서드 (public → private, static → instance)
    public void publicMethod() { }
    private void privateMethod() { }
}
```

### 주석 규칙

**JavaDoc 주석**
- public 클래스/메서드에 JavaDoc 작성
```java
/**
 * 방을 생성하고 플레이어를 추가합니다.
 * 
 * @param roomName 방 이름
 * @param host 방장 플레이어
 * @return 생성된 Room 객체
 */
public Room createRoom(String roomName, Player host) {
    // ...
}
```

**인라인 주석**
- 복잡한 로직에만 간단히 설명
- 코드로 설명 가능하면 주석 지양

### 기타 규칙

**예외 처리**
- 구체적인 예외 타입 사용
- 예외 무시 지양 (최소한 로그 기록)

**null 체크**
- null 가능성이 있으면 명시적 체크
- Optional 활용 고려

**메서드 길이**
- 한 메서드는 한 가지 일만
- 가능하면 20줄 이내

**클래스 책임**
- 단일 책임 원칙 (SRP)
- Controller, Service, Model 역할 분리 유지

<br>

## PR 컨벤션

* PR 시, 템플릿이 등장한다. 해당 템플릿에서 작성해야할 부분은 아래와 같다

    1. `PR 유형 작성`, 어떤 변경 사항이 있었는지 [] 괄호 사이에 x를 입력하여 체크할 수 있도록 한다.

    2. `작업 내용 작성`, 작업 내용에 대해 자세하게 작성을 한다.

    3. `추후 진행할 작업`, PR 이후 작업할 내용에 대해 작성한다

    4. `리뷰 포인트`, 본인 PR에서 꼭 확인해야 할 부분을 작성한다.

    5. `PR 태그 종류`, PR 제목의 태그는 아래 형식을 따른다.

#### 태그 종류 (커밋 컨벤션과 동일)

- `[Feat]`: 새로운 기능 추가
- `[Fix]`: 버그 수정
- `[Design]`: UI/스타일 파일 추가/수정
- `[Refactor]`: 코드 리팩토링
- `[Chore]`: 빌드 업무 수정, 패키지 매니저 설정 등
- `[Docs]`: 문서 추가/수정
- `[Test]`: 테스트 코드 추가/수정
- `[Style]`: 코드 포맷팅, 세미콜론 누락 등

### PR 예시 모음

> 🎉 [Chore] 프로젝트 초기 세팅 <br>
> ✨ [Feat] 프로필 화면 UI 구현 <br>
> 🐛 [Fix] iOS 17에서 버튼 클릭 오류 수정 <br>
> 💄 [Design] 로그인 화면 레이아웃 조정 <br>
> 📝 [Docs] README에 프로젝트 소개 추가 <br>

<br>

## 커밋 컨벤션

### 커밋 태그 가이드

- `[Feat]`: 새로운 기능 추가
- `[Fix]`: 버그 수정
- `[Design]`: UI/스타일 파일 추가/수정
- `[Refactor]`: 코드 리팩토링
- `[Chore]`: 빌드 업무 수정, 패키지 매니저 설정 등
- `[Docs]`: 문서 추가/수정
- `[Test]`: 테스트 코드 추가/수정
- `[Style]`: 코드 포맷팅, 세미콜론 누락 등

### 커밋 예시 모음

> [Chore] 프로젝트 초기 세팅 <br>
> [Feat] 프로필 화면 UI 구현 <br>
> [Fix] iOS 17에서 버튼 클릭 오류 수정 <br>
> [Design] 로그인 화면 레이아웃 조정 <br>
> [Docs] README에 프로젝트 소개 추가 <br>

<br>

## 폴더 컨벤션

```
src/com/hsu/byteship/
├─ common/          # 공통 모듈
├─ server/          # 서버 모듈
└─ client/          # 클라이언트 모듈
```

각 모듈은 패키지 구조를 따라 계층적으로 구성됩니다.

<br>

---

**과목**: 네트워크프로그래밍  
**프로젝트명**: Byteship - Battleship Network Game

