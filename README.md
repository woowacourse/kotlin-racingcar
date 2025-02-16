# kotlin-racingcar

## 기능 요구 사항

---
- 경주
    - [x] 입력받은 이름대로 자동차를 생성한다.
    - [x] 무작위 값 생성 후, 전진 여부 결정
        - [x] 무작위 값이 4 이상일 경우 전진한다.
    - [x] 종료 후, 위치에 따라 우승자 결정
- 입력
    - [x] 자동차 이름
    - [x] 시도 횟수
- 출력
    - [x] 라운드 별 각 자동차의 위치
    - [x] 최종 우승자
## 🚫 예외 상황
<table>
   <tr>
      <td>대상</td>
      <td>상황</td>
   </tr>
    <tr>
      <td rowspan="4">시도 횟수</td>
      <td>빈 경우</td>
    </tr>
    <tr>
      <td>시도 횟수는 long 범위를 입력하지 못한다.</td>
    </tr>
    <tr>
      <td>Int가 아닌 경우</td>
    </tr>
    <tr>
      <td>시도횟수는 1이상만 가능</td>
    </tr>
    <tr>
      <td rowspan="6">자동차 이름</td>
      <td>빈 경우</td>
    </tr>
    <tr>
      <td>구분자로 쉼표(,)가 없는 경우</td>
    </tr>
    <tr>
      <td>구분자로 쉼표(,)만 들어오는 경우 - 빈경우</td>
    </tr>
    <tr>
      <td>같은 이름이 들어온 경우</td>
    </tr>
    <tr>
      <td>이름은 5자 이하</td>
    </tr>
    <tr>
      <td>이름이 한대면 경주 안됨</td>
    </tr>
</table>

## 기능 구현 목록

### 자동차
- 각 자동차의 데이터(이름, 위치)를 다루기 위해 `Car` 클래스를 생성했습니다.
- 객체 생성 시 이름을 전달받으며, 초기 위치는 0으로 설정합니다.
- 올바르지 않은 이름이 입력된 경우 `IllegalArgumentException`을 발생시킵니다.

### 자동차 목록
- 여러 대의 자동차(`List<Car>`)를 다루기 위해 `Cars` 클래스를 생성했습니다.
- 객체 생성 시 자동차들의 이름을 전달받으며, 입력값을 `Car` 객체로 변환하고 저장합니다.
- 중복되는 이름이 존재하거나 자동차가 1대만 입력된 경우 `IllegalArgumentException`을 발생시킵니다.

### 난수 생성
- 숫자 생성을 위한 `NumberGenerator` 인터페이스를 만들고, 해당 인터페이스를 구현하는 `RandomNumberGenerator`를 생성했습니다.
- 정해진 범위(0~9) 내에서 무작위로 숫자를 생성합니다.
- 난수 생성 기능을 `RandomNumberGenerator`에 구현함으로써, 테스트 용이성을 높이고 세부 구현을 드러내지 않게끔 하였습니다.

### 시도 횟수
- 시도 횟수를 다루기 위해 `AttemptCount` 클래스를 생성했습니다.
- 올바르지 않은 값(null, 숫자가 아닌 값 등)이 입력된 경우 `IllegalArgumentException`을 발생시킵니다.
- 프로그램을 실행했을 때 1회만 사용되므로 입력값을 정수로 변환한 후 저장하지 않고, 값이 요구되는 시점에서 메소드를 호출하여 변환된 값을 반환하도록 하였습니다.

### 경주
- 경주의 흐름을 제어하기 위해 `Race` 클래스를 생성했습니다.
- 자동차 리스트와 숫자 생성기를 생성자를 통해 전달받아, 하나의 라운드를 진행하며 게임이 종료되면 우승자를 산출합니다.
- `Race` 클래스는 난수 생성 클래스에 의존하지 않고 인터페이스에 의존하여 난수 생성의 세부 구현에 관심갖지 않도록 하였습니다.


