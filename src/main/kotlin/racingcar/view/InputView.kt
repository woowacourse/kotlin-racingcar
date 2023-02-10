package racingcar.view

import racingcar.utils.BlankRemover
import racingcar.utils.CAR_NAME_DELIMITER
import racingcar.utils.Validator

class InputView(private val validator: Validator) {

    fun readCarNames(): List<String> {
        val names = readln().split(CAR_NAME_DELIMITER).toMutableList()
        BlankRemover.removeBlank(names)

        return validator.checkCarNames(names)
    }

    fun readRoundCount() = validator.checkRoundCount(readln())
}
