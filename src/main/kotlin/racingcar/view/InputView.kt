package racingcar.view

import racingcar.utils.CAR_NAME_DELIMITER
import racingcar.utils.Validator
import racingcar.utils.TextUtils

class InputView(private val validator: Validator) {

    fun readCarNames(): List<String> {
        var names = readln().split(CAR_NAME_DELIMITER).toList()
        names = TextUtils.removeTextsBlank(names)

        return validator.checkCarNames(names)
    }

    fun readRoundCount() = validator.checkRoundCount(readln())
}
