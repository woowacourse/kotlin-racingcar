# kotlin-racingcar

## 기능 명세

### Car

- [x] 전진 조건에 따라 1 씩 move, 혹은 stop 한다.
- [x] 자동차 이름이 올바르지 않을 경우 예외 발생 (`IllegalArgumentException`)
- [x] 위치값을 갖고 있다.

### Cars

- [x] 게임에 출전하는 모든 차를 갖고 있다.
- [x] Car 이름에 중복이 있으면 예외 발생 (`IllegalArgumentException`)
- [x] 경주 한 턴(phase)을 실행한다.
- [ ] 경주 우승자를 생성한다.

### RacingGame

- [x] Cars 을 시도 횟수 만큼 전진/멈춤 시킨다.

### NumberGenerator 인터페이스

이에 대한 구현

- [x] RandomNumberGenerator: 0 ~ 9 중 무작위 숫자(전진 혹은 멈춤)를 리턴한다
- [x] ExplicitNumberGenerator : 직접 지정하는 숫자를 리턴한다 (테스트용)

### TryCount

- [x] 시도횟수가 올바르지 않는 경우 예외 발생 (`IllegalArgumentException`)

### Winners

- [ ] 경주 우승자 목록을 갖고 있다.

### InputView

- [x] 경주할 자동차 이름을 입력 받는다.
- [x] 시도 횟수를 입력받는다.

### OutputView

- [x] 경주 결과를 출력한다.
