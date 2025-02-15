package view

import util.Constants

object InputView {
    fun readCarNames(): List<String> {
        val carNamesInput = readLine(MESSAGE_ENTER_CAR_NAMES)
        val carNames = carNamesInput.split(Constants.DELIMITER_CAR_INPUT).map { it.trim() }
        return carNames
    }

    fun readRounds(): Int {
        val countInput = readLine(MESSAGE_ENTER_ROUNDS_NUMBER)
        val count = countInput.toIntOrNull()
        require(count != null) { MESSAGE_ROUNDS_NOT_INTEGER }
        return count
    }

    private fun readLine(prompt: String): String {
        println(prompt)
        return readlnOrNull() ?: ""
    }

    private const val MESSAGE_ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val MESSAGE_ENTER_ROUNDS_NUMBER = "시도할 횟수는 몇 회인가요?"

    private const val MESSAGE_ROUNDS_NOT_INTEGER = "입력한 경주 횟수는 정수가 아닙니다."
}
