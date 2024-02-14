package racingcar.view.input

import racingcar.model.Car
import racingcar.model.TryCount

class InputView {
    private val inputConverter = InputConverter()
    private val inputValidator = InputValidator()

    fun readCarNames(): List<Car> {
        val inputCarNames = readlnOrNull()
        inputValidator.validateCarNames(inputCarNames)

        return inputConverter.convertCars(inputCarNames)!!
    }

    fun readTryCount(): TryCount {
        val inputTryCount = readlnOrNull()
        inputValidator.validateTryCount(inputTryCount)

        return inputConverter.convertTryCount(inputTryCount!!)
    }
}
