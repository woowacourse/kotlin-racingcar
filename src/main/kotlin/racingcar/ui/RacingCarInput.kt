package racingcar.ui

private const val CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
private const val ROUND_INPUT_MESSAGE = "시도할 회수는 몇회인가요?"

fun getCarNamesByUser(): String? {
    println(CAR_NAME_INPUT_MESSAGE)
    return readLine()
}

fun getRoundByUser(): String? {
    println(ROUND_INPUT_MESSAGE)
    return readLine()
}
