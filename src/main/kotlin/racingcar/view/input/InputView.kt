package racingcar.view.input

import racingcar.model.Car
import racingcar.model.TryCount

object InputView {
    fun readCarNames(): List<Car> {
        val inputCarNames = readlnOrNull()
        InputValidator.validateCarNames(inputCarNames)

        return InputConverter.convertCars(inputCarNames!!)
    }

    fun readTryCount(): TryCount {
        val inputTryCount = readlnOrNull()
        InputValidator.validateTryCount(inputTryCount)

        return InputConverter.convertTryCount(inputTryCount!!)
    }
}
