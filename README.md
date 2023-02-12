# 자동차 경주 게임

## 기능 요구 사항
-[x] 자동차 이름 입력 받기
    -[x] 이름에 중복이 있을 경우 예외 처리
    -[ ] 입력받은 자동차의 수가 2대 미만 20대 초과인 경우 예외 처리 
    -[x] 이름은 ","로 구분
        -[x] 이름 사이와 양 끝 공백 제거
        -[x] 이름 null인 경우 예외 처리
        -[x] 이름 empty인 경우 예외 처리
        -[x] 이름 5글자 이상일 경우 예외 처리
        -[x] 이름 한글(자음과 모음만 있을 경우는 예외), 영어가 아닌 경우 예외 처리  
-[x] 시도 횟수 입력 받기
    -[x] 횟수 null인 경우 예외 처리
    -[x] 횟수 empty(공백)인 경우 예외 처리
    -[x] 횟수 숫자가 아닌 경우 예외 처리
    -[ ] 시도횟수가 1회 이상 100회 이하가 아닌 경우 예외 처리 
-[x] 0에서 9사이의 랜덤값 생성
-[x] 시도횟수 만큼 자동차들 이동
    -[x] 4미만의 값이 들어올 경우 정지
    -[x] 4이상의 값이 들어올 경우 전진
-[x] 시도횟수만큼 자동차들이 이동한 결과를 출력
-[x] 이동한 길이가 가장 긴 자동차 이름을 출력
  -[x] 이동한 길이가 가장 긴 자동차가 여러 개일 경우 리스트 출력
  -[ ] 이동한 길이가 전부 0인 경우 우승자 없음으로 출력 


