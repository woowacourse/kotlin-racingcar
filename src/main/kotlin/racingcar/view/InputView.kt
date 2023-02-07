package racingcar.view

import racingcar.utils.Validator

class InputView(private val validator: Validator) {

    fun readCarNames(): List<String> {
        val input = readln()

        return validator.checkCarNames(input)
    }

}
