package racingcar.controller

import racingcar.model.Car
import racingcar.model.Game
import racingcar.model.RandomNumberFactory
import racingcar.model.Rounds
import racingcar.util.retryWhenException
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    fun start() {
        val game = settingGame()
        val rounds = getRounds()
        playGame(rounds, game)
    }

    private fun settingGame(): Game {
        return retryWhenException(
            action = {
                val cars = getCars()
                Game(cars, randomNumberFactory())
            },
            onError = {
                outputView.printErrorMessage(it)
            },
        )
    }

    private fun getCars(): List<Car> {
        val input = inputView.readCarNames()
        val carNames = getCarNames(input)
        val cars = carNames.map { Car(it) }
        return cars
    }

    private fun getCarNames(input: String): List<String> {
        return input.split(SEPARATOR).map { it.trim() }
    }

    private fun getRounds(): Rounds {
        return retryWhenException(
            action = {
                val input = inputView.readRounds()
                Rounds(input)
            },
            onError = {
                outputView.printErrorMessage(it)
            },
        )
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
        val winnersMsg = winners.joinToString("$SEPARATOR ")
        outputView.printWinners(winnersMsg)
    }

    private fun playRound(game: Game) {
        game.playRound()
        val roundResult = game.getRoundResult()
        val roundResultMessage = roundResult.joinToString("\n")
        outputView.printRoundResult(roundResultMessage)
    }

    private fun randomNumberFactory() =
        RandomNumberFactory {
            val randomNumberRange = RANDOM_NUMBER_MIN..RANDOM_NUMBER_MAX
            (randomNumberRange).random()
        }

    companion object {
        const val SEPARATOR = ","

        const val RANDOM_NUMBER_MIN = 0
        const val RANDOM_NUMBER_MAX = 9
    }
}
