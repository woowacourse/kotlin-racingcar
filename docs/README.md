# 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.

- 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

## 코드 구조
### 입출력
- InputView/OutputView 에서 담당한다.

### RaceCar
레이싱차의 상태나 동작은 Car 에서 관리한다.
- name
- distance
- moveOrStop(score: Int) (function)
  - score (0..4) : stop
  - score (<= 5) : go

### RaceCars
- 가장 선두에 있는 차 그룹을 찾는다
- RaceCar 들을 moveOrStop 한다

### NumberGenerator
- 숫자 생성기

### RaceCarGameController
- InputView 에서 전달 받은 차 이름으로 cars 를 생성
- cars 와 NumberGenerator 로 raceCarGame 을 생성
- InputView 에서 전달 받은 trialCount 만큼 raceCarGame 을 시행하다.
- raceCarGame 의 winners 를 찾는다

# 출력 요구 사항
위 요구 사항에 따라 3대의 자동차가 5번 움직였을 경우 프로그램을 실행한 결과는 다음과 같다.
```
경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5

실행 결과
pobi : -
woni :
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자: pobi, jun
```