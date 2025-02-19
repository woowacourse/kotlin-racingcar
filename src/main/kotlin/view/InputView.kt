package view

object InputView {
    fun readCarNames(): List<String> {
        val carNamesInput = readlnOrNull() ?: ""
        val carNames = carNamesInput.split(DELIMITER_CAR_INPUT).map { it.trim() }
        return carNames
    }

    fun readRounds(): Int {
        val countInput = readlnOrNull() ?: ""
        val count = countInput.toIntOrNull()
        require(count != null) { MESSAGE_ROUNDS_NOT_INTEGER }
        return count
    }

    private const val DELIMITER_CAR_INPUT = ","

    private const val MESSAGE_ROUNDS_NOT_INTEGER = "입력한 경주 횟수는 정수가 아닙니다."
}
