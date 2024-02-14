# kotlin-racingcar

## 기능 명세

### Car

- [ ] 전진 조건에 따라 1 씩 move, 혹은 stop 한다.
- [x] 자동차 이름이 올바르지 않을 경우 예외 발생 (`IllegalArgumentException`)
- [ ] 위치값을 갖고 있다.

### RacingGame
- [ ] 각 Car 들을 시도 횟수 만큼 전진/멈춤 시킨다.
- [ ] 각 Car 이름에 중복이 있으면 예외 발생 (`IllegalArgumentException`)
- [ ] 게임에 출전할 Car 들을 갖고 있다.

### NumberGenerator 인터페이스

이에 대한 구현

- [x] RandomNumberGenerator: 0 ~ 9 중 무작위 숫자(전진 혹은 멈춤)를 리턴한다
- [ ] MoveNumberGenerator : 무조건 전진하는 숫자를 리턴한다
- [ ] StopNumberGenerator: 무조건 멈추는 숫자를 리턴한다

### TryCount

- [ ] 시도횟수가 올바르지 않는 경우 예외 발생 (`IllegalArgumentException`)

### InputView

- [ ] 경주할 자동차 이름을 입력 받는다.
- [ ] 시도 횟수를 입력받는다.

### OutputView

- [ ] 경주 결과를 출력한다.
