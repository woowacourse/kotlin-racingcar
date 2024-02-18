# 수정 목록
## 프로젝트
- [x] : view, domain, controller 로 패키징

## View
- [x] : InputView : 시도 횟수 검증문 toIntOrNull()로 리팩토링
- [ ] : OutputView : StringBuilder 대신 kotlin dsl 함수인 buildString 로 리팩토링
- [ ] : error message 좀 더 명시적으로 수정  

## controller
- [ ] : Random.Int() -> random() 로 리팩토링
- [ ] : Error 핸들링
- [ ] : 무분별한 scope 함수, Extension 레팩토링
## domain 쪽
### RaceCar
- [ ] : 빈 문자열 검증 가독성 리팩토링
- [ ] : ParameterizedTest 로 test 리팩토링 
- [ ] : 불필요한 compare 함수 삭제

### RaceCars
- [ ] : winners 찾는 과정 수정