package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.RacingGame
import racingcar.domain.RandomNumberGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingGameController(private val inputView: InputView, private val outputView: OutputView) {

    fun run() {
        val carNames = inputView.sendCarName()
        val rowCars = carNames.map { Car(it) }
        val cars = Cars(rowCars)
        val round = inputView.sendRound()
        val racingGame = RacingGame(cars, round, RandomNumberGenerator())
        outputView.printResult()
        while (racingGame.isNotEnd()) {
            val playedCars = racingGame.playOneRound()
            outputView.printRoundResult(playedCars)
        }
        val winningCars = racingGame.findWinningCars()
        outputView.printWinners(winningCars)
    }
}
