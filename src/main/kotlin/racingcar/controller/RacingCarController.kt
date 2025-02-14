package racingcar.controller

import racingcar.model.Car
import racingcar.model.Game
import racingcar.model.Rounds
import racingcar.util.retryWhenException
import racingcar.validator.InputValidator
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    fun start() {
        val cars = getCars()
        val rounds = getRounds()
        val game = Game(cars)
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
        return input.split(SEPARATOR).map { it.trim() }
    }

    private fun getRounds(): Rounds {
        return retryWhenException {
            val input = inputView.readRounds()
            Rounds(input)
        }
    }

    private fun playGame(
        rounds: Rounds,
        game: Game,
    ) {
        outputView.printGameResultMessage()
        repeat(rounds.value) {
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
        const val SEPARATOR = ","
    }
}
