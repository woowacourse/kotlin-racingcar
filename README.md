# kotlin-racingcar

## 기능 요구 사항

---
- 경주
    - 입력받은 이름대로 자동차를 생성한다.
    - 무작위 값 생성 후, 전진 여부 결정
        - 무작위 값이 4이상일 경우, 전진
    - 종료 후, 위치에 따라 우승자 결정
- 입력
    - 자동차 이름
    - 시도 횟수
- 출력
    - 횟수마다 각 자동차의 위치
    - 최종 우승자
## 🚫 예외 상황
<table>
   <tr>
      <td>대상</td>
      <td>구현 여부</td>
      <td>상황</td>
   </tr>
    <tr>
      <td rowspan="4">시도 횟수</td>
      <td>O</td>
      <td>빈 경우</td>
    </tr>
    <tr>
      <td>O</td>
      <td>시도 횟수는 long 범위를 입력하지 못한다.</td>
    </tr>
    <tr>
      <td>O</td>
      <td>Int가 아닌 경우</td>
    </tr>
    <tr>
      <td>O</td>
      <td>시도횟수는 1이상만 가능</td>
    </tr>
    <tr>
      <td rowspan="6">자동차 이름</td>
      <td>O</td>
      <td>빈 경우</td>
    </tr>
    <tr>
      <td>O</td>
      <td>구분자로 쉼표(,)가 없는 경우</td>
    </tr>
    <tr>
      <td>O</td>
      <td>구분자로 쉼표(,)만 들어오는 경우 - 빈경우</td>
    </tr>
    <tr>
      <td>O</td>
      <td>같은 이름이 들어온 경우</td>
    </tr>
    <tr>
      <td>O</td>
      <td>이름은 5자 이하</td>
    </tr>
    <tr>
      <td>O</td>
      <td>이름이 한대면 경주 안됨</td>
    </tr>
</table>
