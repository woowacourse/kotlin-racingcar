package racingcar.view

import racingcar.utils.removeBlank

class InputView {
    fun readCarNames(): List<String> = readln()
        .split(CAR_NAME_DELIMITER)
        .removeBlank()

    fun readNumber(): Int {
        val number = readln().toIntOrNull()
        requireNotNull(number) { NOT_NUMERIC_ERROR_MESSAGE }

        return number
    }

    companion object {
        private const val CAR_NAME_DELIMITER = ","
        private const val NOT_NUMERIC_ERROR_MESSAGE = "입력값이 숫자가 아닙니다."
    }
}
