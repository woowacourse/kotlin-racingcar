package racingcar.controller

import racingcar.validator.CarNamesValidator
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun start() {
        val carNames = inputView.readCarNames()
        validateCarNames(carNames)
        val rounds = inputView.readRounds()
    }

    private fun validateCarNames(input: String): List<String> {
        val validator = CarNamesValidator()
        return validator.validate(input)
    }
}
