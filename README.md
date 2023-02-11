# 자동차 경주 게임

## 기능목록

### 입력

* 경주할 자동차 이름을 입력받는다.
    * 자동차 개수는 2대 이상 20대 이하여야 한다.
    * 자동차 이름은 영문 소문자, 공백 X.
    * 자동차 이름은 1글자 이상 5글자 이하여야 한다.
    * 자동차 이름은 중복되면 안 된다.
    * 자동차 이름은 ,로 구분된다.
* 경주 시도 횟수를 입력받는다.
    * 시도 횟수는 숫자여야 한다.
    * 시도 횟수는 1이상 10이하여야 한다.

### 도메인

* 0 에서 9 숫자를 랜덤으로 생성한다.
* 0 ~ 3 = stop, 4 ~ 9 = go
* 거리가 가장 큰 최종 우승자를 찾는다.

### 출력

* 실행 결과를 출력한다.
    * pobi : -
* 최종 우승자를 출력한다.
    * 최종 우승자는 한 명 이상일 수 있다.
    * 최종 우승자: pobi, jun

## 구조

- controller
    - Controller
- domain
    - Car
    - Judgement
    - NumberGenerator
    - RandomNumberGenerator
- data
    - Movement
- dto
- view
    - InputView
    - OutputView