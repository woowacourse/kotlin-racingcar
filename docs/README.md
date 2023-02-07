## 요구 사항 문서

## 입력
- [ ] 이름을 입력 받는다.
- [ ] 시도 횟수를 입력 받는다.

### 예외 처리
#### 이름
- [ ] 이름 1자 이상 5자 이하여야 한다.
<!-- - [ ] 쉼표를 제외한 특수문자는 입력할 수 없다. -->

#### 게임 시도 횟수
- [ ] 횟수는 숫자만 입력해야 한다.
- [ ] 횟수는 양의 정수여야 한다.

## 출력
- [ ] 게임 시작 안내 문구를 출력한다.
- [ ] 시도 횟수 안내 문구를 출력한다.
- [ ] 라운드 결과를 출력한다.
- [ ] 최종 우승자를 출력한다.

## 기능
- [ ] 무작위 수를 뽑는 함수를 구현한다.
- [ ] 무작위 수가 4 이상인지 확인한다.
- [ ] 우승한 사람을 반환하는 함수를 구현한다.


## 구현할 기능 목록
1. NameException 클래스
+ 이름 입력 시 발생하는 예외 처리 클래스 
- [ ] checkNameRange - 이름이 5자 초과하는지 check 

2. TryCountException 클래스
+ 게임 시도 횟수 입력 시 발생하는 예외 처리 클래스
- [ ] checkTryCountInteger : 시도 횟수가 숫자인지 check
- [ ] checkTryCountPositive : 시도 횟수가 양의 정수인지 check

3. InputView 클래스
+ 게임 진행 시 발생하는 입력 처리 클래스
- [ ] inputName : 이름을 입력 받는다 
- [ ] inputTryCount : 시도 횟수를 입력 받는다

4. OutputView 클래스
+ 게임 진행 시 출력 처리 클래스
- [ ] printGameStart : 게임 시작 안내 문구를 출력한다
- [ ] printTryCount : 시도 횟수 안내 문구를 출력한다
- [ ] printRoundResult : 라운드 결과를 출력한다
- [ ] printWinner : 최종 우승자를 출력한다

5. Car 클래스
+ Car는 자동차 이름과 위치 정보를 가지는 클래스
+ String: carName, Int: position