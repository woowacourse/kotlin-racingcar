package racingcar.view

import racingcar.constant.ERROR_NAME_LENGTH
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
}
