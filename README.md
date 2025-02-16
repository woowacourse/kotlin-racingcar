

## 📖 프로젝트 개요
이 프로젝트는 자동차명, 시도 횟수를 입력하여 우승자를 출력하는 프로그램이다.
---
## 🔍 주요 기능
- 자동차 명을 입력한다.
- 시도횟수를 입력한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 자동차는 `,` 기준으로 구분한다.
- 전진하는 조건은 0-9 사이에서 무작위 값을 구한 후 4이상일 경우이다.
- 자동차 상태를 출력한다.
- 우승자를 출력한다. 우승자는 한 명 이상일 수 있다.

---
## 🛠️ 필요한 기능

### 자동차
- [x] 자동차의 전진, 정지 여부
- [x] 자동차의 전진 횟수
- [x] 자동차의 이름
### 경주
- [x] 마지막 라운드의 경우, 각 자동차의 전진 횟수에 따라 우승자 도출
- [x] 경주할 자동차 이름 리스트 생성
### 랜덤숫자
- [x] 0-9 사이 무작위 숫자 생성
### 예외처리
- [x] 자동차 명이 5자 초과인 경우
- [x] 자동차 명이 공백일 경우
- [x] 자동차 명이 중복일 경우
- [x] 입력한 시도 횟수가 숫자가 아닐 경우
- [x] 입력한 시도 횟수가 공백일 경우
- [x] 입력한 시도 횟수가 0 이하일 경우

### 사용자 화면
- 자동차 이름을 입력한다.
- 시도 횟수를 입력한다.
- 경주 실행 결과를 출력한다.
- 우승자를 출력한다.