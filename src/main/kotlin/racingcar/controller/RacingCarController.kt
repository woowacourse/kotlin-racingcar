package racingcar.controller

import racingcar.model.Car
import racingcar.model.Game
import racingcar.util.retryWhenException
import racingcar.validator.CarNamesValidator
import racingcar.validator.RoundsValidator
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun start() {
        val carNames =
            retryWhenException {
                val input = inputView.readCarNames()
                validateCarNames(input)
            }

        val rounds =
            retryWhenException {
                val input = inputView.readRounds()
                validateRounds(input)
            }

        val cars = carNames.map { Car(it) }
        val game = Game(cars)
        repeat(rounds) {
            game.playRound()
            val roundResult = game.getRoundResult()
        }
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
