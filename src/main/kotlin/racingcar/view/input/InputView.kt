package racingcar.view.input

import racingcar.model.Car

class InputView {
    private val inputConverter = InputConverter()
    private val inputValidator = InputValidator()

    fun readCarNames(): List<Car> {
        val inputCarNames = readlnOrNull()
        inputValidator.validateCarNames(inputCarNames)

        return inputConverter.convertCars(inputCarNames)!!
    }
}