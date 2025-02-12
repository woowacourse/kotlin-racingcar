package racingcar.controller

import racingcar.util.retryWhenException
import racingcar.validator.CarNamesValidator
import racingcar.validator.RoundsValidator
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun start() {
        retryWhenException {
            val carNames = inputView.readCarNames()
            validateCarNames(carNames)
        }

        val rounds = inputView.readRounds()
        validateRounds(rounds)
    }

    private fun validateCarNames(input: String): List<String> {
        val validator = CarNamesValidator()
        return validator.validate(input)
    }

    private fun validateRounds(input: String): Int {
        val validator = RoundsValidator()
        return validator.validate(input)
    }
}
