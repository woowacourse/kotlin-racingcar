package racingcar.view

import racingcar.constant.ERROR_NAME_LENGTH
import racingcar.constant.ERROR_WRONG_NUMBER
import racingcar.domain.Validator

class InputView {
    fun getCarsName() {
        val input = readLine()?.trim()

        if (!input.isNullOrBlank()) {
            checkNameLength(input.split(","))
        } else {
            throw IllegalArgumentException(ERROR_NAME_LENGTH)
        }
    }

    fun checkNameLength(value: List<String>) {
        value.forEach {
            require(Validator.isNameLengthInRange(it)) { ERROR_NAME_LENGTH }
        }
    }

    fun getTrialNumber(): Int {
        val input = readLine()?.trim()

        if (!input.isNullOrBlank()) {
            require(Validator.isNumber(input)) { ERROR_WRONG_NUMBER }
        } else {
            throw IllegalArgumentException(ERROR_WRONG_NUMBER)
        }

        return input.toInt()
    }
}
