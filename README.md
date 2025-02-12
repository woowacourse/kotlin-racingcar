# kotlin-racingcar

## 구현할 기능 목록
### 1) 경주할 자동차 이름 입력 받기
- 입력 조건
- [ ] "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
- [ ] 자동차 이름은 5자를 초과할 수 없음
- [ ] 각 이름은 ,을 기준으로 구분함
- 예외 처리
- [ ] 빈칸인 경우 예외 처리
- [ ] 자동차 이름이 5자를 초과하는 경우
- [ ] ,로 구분이 불가능 한 경우
- [ ] 자동차 이름에 숫자가 들어가는 경우
- [ ] 자동차 이름이 중복되는 경우

### 2) 시도할 횟수 입력 받기
- 입력 조건
- [ ] "시도할 횟수는 몇 회인가요?"
- [ ] 숫자로 횟수를 입력받기
- 예외 처리
- [ ] 숫자가 아닌 경우 예외 처리(영어 등)
- [ ] 빈칸인 경우 예외 처리

### 3) 경주 실행하기
- 실행 조건
- [ ] 각 차별로 0에서 9사이의 랜덤의 수 생성하기
- [ ] 랜덤 값이 4 이상인 경우 전진하도록 함

### 4) 경주 현황 출력하기
- 출력 조건
- [ ] 차 이름과 실행 결과를 출력 ex) pobi : -

### 4) 우승자 결정하기
- 우승자 결정 조건
- [ ] 가장 많이 전진한 경우 우승자로 결정
- [ ] 전진한 횟수가 동일하면 ,를 붙여 출력함

### 프로그래밍 요구 사항
- [ ] indent depth가 3이 넘지 않도록 함
- [ ] 모든 로직에 단위 테스트를 구현
- [ ] 함수의 길이가 15라인을 넘어가지 않도록 구현

### 힌트
- [ ] 사용자가 입력한 이름의 숫자 만큼 자동차 대수를 생성하기
- [ ] 자동차는 자동차 이름과 위치 정보를 가지는 Car 객체를 추가해 구현함