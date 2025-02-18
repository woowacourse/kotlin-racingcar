# kotlin-racingcar

- 구현: 실행 순서에 따른 기능 목록 작성
    - 자동차 입력 기능 구현
    - 시도할 횟수 입력 기능 구현
    - 자동차 주행 기능 추가
    - 자동차 이름과 횟수를 입력받는 메소드 추가
    - 시도 횟수에 따른 자동차 이동 기능 추가
    - 자동차 상태 출력 기능 구현
    - 레이스 우승자 출력
    - 레이스에 자동차 출력 기능 추가
    - 레이스 결과 출력 추가
    - 자동차 생성하는 기능 추가
    - 자동차 익명 이름들 추가 검증
    - 중복된 이름 제거 기능 추가
    - 레이스 실행 추가

- 리팩토링
  - 최종 우승자 출력 역할 분리
  - 하드코딩 상수화
  - 내부 함수 접근 제한
  - 자동차 이동 기능 분리
  - 랜덤 값 생성 기능 분리

- 수정사항
  - CarTest에 NumberGenerator를 테스트 하기 위한 전략 패턴 도입
  - Racing에서 carName의 검증을 InputView에서 검증하도록 수정
  - 각 클래스 별로 상수 분리