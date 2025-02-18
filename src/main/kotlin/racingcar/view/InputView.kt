package racingcar.view

object InputView {
    fun inputCarNames(): List<String> {
        val input = readLine(INPUT_CAR_NAME_MESSAGE)
        input.validateInput()
        val carNames = input.split(DELIMITER).filter { it.isNotBlank() }

        return carNames
    }

    fun inputRacingCount(): String {
        val input = readLine(INPUT_COUNT_MESSAGE)
        input.validateInput()

        return input
    }

    private fun String.validateInput() {
        require(this.isNotBlank()) { EMPTY_INPUT_MESSAGE }
    }

    private fun readLine(message: String): String {
        println(message)
        return readlnOrNull() ?: ""
    }

    private const val INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val INPUT_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"
    private const val DELIMITER = ","
    private const val EMPTY_INPUT_MESSAGE = "빈 문자열입니다."
}
