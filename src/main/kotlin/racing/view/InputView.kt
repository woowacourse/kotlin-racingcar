package racing.view

import racing.validators.UserInputValidator

object InputView {
    fun inputCarNames(): List<String> {
        val userInput = readLine()
        val carNames = userInput!!.split(",")
        for (carName in carNames) {
            UserInputValidator.validateUserCarNameLength(carName)
            UserInputValidator.validateUserCarNameBlank(carName)
        }

        return carNames
    }

    fun inputCount(): Int {
        val userInput = readLine()
        return userInput!!.toInt()
    }
}
