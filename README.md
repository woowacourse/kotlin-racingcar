# kotlin-racingcar

## 기능 명세

### Car

- [ ] 자동차가 한 칸 전진한다.
- [x] 자동차 이름이 올바르지 않을 경우 예외 발생 (`IllegalArgumentException`)
- [x] 위치값을 갖고 있다.

### Cars

- [x] 게임에 출전하는 모든 차를 갖고 있다.
- [x] Car 이름에 중복이 있으면 예외 발생 (`IllegalArgumentException`)
- [x] 경주 한 턴(phase)을 실행한다.
- [x] 경주 한 턴(phase)을 시작한다. 이 때 이동 전략을 전달받아서 전략에 따라 자동차들을 이동시킨다.

### RacingGame

- [x] Cars 을 시도 횟수 만큼 전진/멈춤 시킨다.

### NumberGenerator 인터페이스

이에 대한 구현

- [x] RandomNumberGenerator: 0 ~ 9 중 무작위 숫자(전진 혹은 멈춤)를 리턴한다
- [x] ExplicitNumberGenerator : 직접 지정하는 숫자를 리턴한다 (테스트용)

### MoveStrategy 인터페이스

- [x] move 메서드를 가진다. 이것의 조건에 따라 자동차를 움직이게 한다.

### MoveStrategyUsingNumber

- [x] 한 자리 숫자를 이동의 조건으로 한다.
- 만약 한자리 숫자가 4 이상이면 자동차를 움직이게 한다.

### TryCount

- [x] 시도횟수가 올바르지 않는 경우 예외 발생 (`IllegalArgumentException`)

### InputView

- [x] 경주할 자동차 이름을 입력 받는다.
- [x] 시도 횟수를 입력받는다.

### OutputView

- [x] 경주 결과를 출력한다.
