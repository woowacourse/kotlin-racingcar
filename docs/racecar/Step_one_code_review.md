# 수정 목록
## 프로젝트
- [x] : ktFormat pre-push hook 설정
- [x] : 자동차 경주 패키징하기

## domain 쪽
### RaceCar
- [x] : name WhiteSpace 있는지 검증 
- [x] : move 방식 동적으로 세팅할 수 있도록 수정
- [x] : 생성자에 position 을 받을 수 있도록 수정  
- [x] : RaceCar data class -> class 로 수정
- [x] : 거리 비교하는 로직 Comparable 이 아닌 comparePosition() 으로 수정

### RaceCars
- [x] : RaceCars cars 멤버 변수 public 전환 
- [x] : RaceCars data class -> class 로 수정
- [x] : RaceCars 팩토리 메서드 함수 from() -> invoke() 수정

## controller
- [x] : view 와 ScoreGenerator 를 생성자에서 주입 받는 형태로 수정

## View
- [x] : 이름 사이의 띄어쓰기를 제거
- [x] : object -> class 로 변경
- [x] : 기존 Domain 에서 처리한 format 로직 UI로 옮기기
- [x] : InputView, OutputView -> KernelRaceCarGameInputView, KernelRaceCarGameOutputView 로 변경 (Terminal 용 view)
- [x] : carNames, trialCount 입력 요청 print 문 OutputView -> InputView 로 이동