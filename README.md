# 자동차 경주 게임 ⚾️

---
### 핵심 기능
`무작위 값에 따라 자동차 전진 시키기`


## 기능 목록
### 비즈니스 로직 ⚒️ 
- [ ] 사용자는 경주할 자동차 이름과 시도할 횟수를 입력한다.
- [ ] 컴퓨터는 1부터 9까지 수 중 하나를 임의로 선택한다.
  - [ ] 선택된 숫자가 4 이상이면 전진한다.
- [ ] 경주 게임이 진행된다.
  - [ ] 경주 게임은 사용자가 입력한 시도 횟수만큼 반복된다.
- [ ] 경주 게임이 완료되면 우승자가 결정되고 게임이 종료된다.

### Input 📥
- [x] 경주할 자동차 이름을 입력받는다.
- [ ] 시도할 횟수를 입력받는다.

### 입력 예외 처리 🧹
- 경주할 자동차 이름
  - [x] 이름을 입력하지 않은 경우
  - [x] 이름이 5자가 넘는 경우
  - [x] 이름에 알파벳이 아닌 숫자, 특수문자 등이 포함되는 경우
  - [x] 중복된 이름이 존재하는 경우


- 시도할 횟수
  - [x] 시도할 횟수를 입력하지 않은 경우
  - [x] 숫자가 아닌 알파벳, 특수문자 등이 포함되는 경우
  - [x] 시도할 횟수가 1보다 작은 경우
  - [x] 시도할 횟수가 1,000보다 큰 경우

### Output 📤
- [ ] 게임 시작 알림 문구를 출력한다.
- [ ] 시도할 횟수 알림 문구를 출력한다.
- [ ] 각 실행별 실행 결과를 출력한다.
- [ ] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
  - [ ] 우승자는 한 명 이상일 수 있다. 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

### 프로그래밍 요구사항 🧐
* 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
* indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
* 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.

---