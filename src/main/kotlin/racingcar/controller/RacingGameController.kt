package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.RacingGame
import racingcar.domain.RandomNumberGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingGameController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {

    fun run() {
        val racingGame = createRacingGame()
        play(racingGame)
        printWinners(racingGame)
    }

    private fun createRacingGame(): RacingGame {
        val cars = createCars()
        val round = inputView.sendRound()
        return RacingGame(cars, round, RandomNumberGenerator())
    }

    private fun createCars(): Cars {
        val carNames = inputView.sendCarName()
        val rowCars = carNames.map { Car.from(it) }
        return Cars(rowCars)
    }

    private fun play(racingGame: RacingGame) {
        outputView.printResult()
        while (racingGame.isNotEnd()) {
            val playedCars = racingGame.playOneRound()
            outputView.printRoundResult(playedCars)
        }
    }

    private fun printWinners(racingGame: RacingGame) {
        val winningCars = racingGame.findWinningCars()
        outputView.printWinners(winningCars)
    }
}
