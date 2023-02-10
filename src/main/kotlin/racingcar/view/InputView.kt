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

    fun readRoundCount() = validator.checkRoundCount(readln())

    companion object {
        const val CAR_NAME_DELIMITER = ","
    }
}
