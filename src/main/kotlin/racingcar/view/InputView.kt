package racingcar.view

import racingcar.utils.Validator
import racingcar.utils.removeBlank

class InputView(private val validator: Validator) {

    fun readCarNames(): List<String> {
        val names = readln()
            .split(CAR_NAME_DELIMITER)
            .removeBlank()
        return validator.checkCarNames(names)
    }

    fun readNumber(): Int {
        val number = readln().toIntOrNull()
        requireNotNull(number) { NOT_NUMERIC_ERROR_MESSAGE }

        return number
    }

    companion object {
        const val CAR_NAME_DELIMITER = ","
        const val NOT_NUMERIC_ERROR_MESSAGE = "입력값이 숫자가 아닙니다."
    }
}
