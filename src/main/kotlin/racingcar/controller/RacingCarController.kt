package racingcar.controller

import racingcar.model.Car
import racingcar.model.Game
import racingcar.util.retryWhenException
import racingcar.validator.InputValidator
import racingcar.validator.RoundsValidator
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    fun start() {
        val cars = getCars()
        val rounds = getRounds()
        val game = getGame(cars)
        playGame(rounds, game)
    }

    private fun getCars(): List<Car> {
        return retryWhenException {
            val input = inputView.readCarNames()
            InputValidator.validateNotEmpty(input)
            val carNames = getCarNames(input)
            carNames.map { Car(it) }
        }
    }

    private fun getCarNames(input: String): List<String> {
        return input.split(COMMA).map { it.trim() }
    }

    private fun getGame(cars: List<Car>): Game {
        return retryWhenException {
            Game(cars)
        }
    }

    private fun getRounds(): Int {
        return retryWhenException {
            val input = inputView.readRounds()
            InputValidator.validateNotEmpty(input)
            RoundsValidator.validate(input)
            input.toInt()
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

    companion object {
        const val COMMA = ","
    }
}
