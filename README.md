# kotlin-racingcar

## 기능 목록 
1. 입력
   - 자동차 목록 
     - 쉼표, 를 기준으로 구분한다.  
     - 각 자동차 이름은 5자 초과 불가, 공백 불가, 중복 불가
   - 시도할 횟수
   
2. 출력
   - 실행 결과 
   - 최종 우승자

3. 게임 진행
   - 시도 횟수와 자동차 이름 목록을 받는다.
   - 자동차를 생성한다. 
   - 시도 횟수만큼 게임을 진행한다.
   - 게임을 종료하고, 최종 우승자를 판단한다. 
   
4. 자동차
   - 위치를 가진다. 
   - 이름을 가진다.
   - 조건에 맞게 전진한다. 
     - 조건 : 0~9 사이 무작위 값중 4 이상 전진 