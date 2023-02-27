# 자동차 경주 게임

## 게임 시작 전
- [x] 이름 입력 받기
  - [x] 자동차 이름이 5자를 넘는지 체크
- [x] 횟수 입력 받기

## 게임 중

- [x] 랜덤 값에 따라 분기처리
  - [x] 랜덤 값 생성
  - [x] 4이상인지 판단
  - [x] 차량 전진

## 게임 종료

- [x] 우승자 판단
- [x] 우승자 출력

<br/>

* * *
<br/>

## 리팩터링한 부분

- [x] view(InputView, OutputView)를 object로 변환
- [x] 스트림 함수 사용하여 코드 줄이기
- [x] backing field로 처리했던 원시타입 변수를 커스텀 setter로 대신 처리
- [x] gameController의 세 개의 phase를 runGame이라는 함수로 묶어서 한번에 실행
- [x] 상수화한 에러메시지의 확장성 추가
- [x] Car의 decideCarMovement 함수명을 move로 변경
- [x] DriverDecision enum class 위치를 util에서 domain 패키지로 변경
- [x] 테스트 코드 분기처리 삭제 후 테스트 2개로 분리
- [x] 테스트 케이스 네이밍 변경
- [x] CarFactory 클래스를 따로 분류해서 GameController의 역할을 줄임