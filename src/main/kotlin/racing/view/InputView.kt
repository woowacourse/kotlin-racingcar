package racing.view

import racing.validators.UserInputValidator

class InputView {
    fun inputCarNames(): String {
        val userInput = readLine()
        val carNames = userInput!!.split(",")
        for (carName in carNames) {
            UserInputValidator.validateUserCarNameLength(carName)
            UserInputValidator.validateUserCarNameBlank(carName)
        }

        return userInput
    }

    fun inputCount(): Int {
        val userInput = readLine()
        return userInput!!.toInt()
    }
}
