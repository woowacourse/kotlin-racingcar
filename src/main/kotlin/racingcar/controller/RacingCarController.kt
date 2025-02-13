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
        val cars = getCars()
        val rounds = getRounds()
        val game = Game(cars)
        playGame(rounds, game)
    }

    private fun getCars(): List<Car> {
        val carNames =
            retryWhenException {
                val input = inputView.readCarNames()
                validateCarNames(input)
            }
        return carNames.map { Car(it) }
    }

    private fun getRounds(): Int {
        return retryWhenException {
            val input = inputView.readRounds()
            validateRounds(input)
        }
    }

    private fun playGame(
        rounds: Int,
        game: Game,
    ) {
        outputView.printGameResultMessage()
        repeat(rounds) {
            playRound(game)
        }
        val winners = game.getWinners()
        outputView.printWinners(winners)
    }

    private fun playRound(game: Game) {
        game.playRound()
        val roundResult = game.getRoundResult()
        outputView.printRoundResult(roundResult)
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
