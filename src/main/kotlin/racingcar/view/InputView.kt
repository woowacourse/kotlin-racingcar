package racingcar.view

import racingcar.utils.TEXT_IN_LINE_DELIMITER
import racingcar.utils.Validator
import racingcar.utils.TextUtils

class InputView(private val validator: Validator) {

    fun readCarNames(): List<String> {
        var names = readln().split(TEXT_IN_LINE_DELIMITER).toList()
        names = TextUtils.removeTextsBlank(names)

        return validator.checkCarNames(names)
    }

    fun readRoundCount() = validator.checkRoundCount(readln())
}
