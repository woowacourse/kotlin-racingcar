package racingcar.view

// 최상위 수준의 상수 정의
private const val CAR_NAME_PROMPT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
private const val TRY_NUMBER_PROMPT = "시도할 횟수는 몇 회인가요?"

fun inputCar() {
    println(CAR_NAME_PROMPT)
}

fun inputTry() {
    println(TRY_NUMBER_PROMPT)
}