package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.RaceManager
import racingcar.domain.RandomNumberGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

class GameController() {
    private val output by lazy { OutputView() }
    private val input by lazy { InputView() }
    private val raceManager = RaceManager(RandomNumberGenerator(), input.inputCarNames(), input.inputRacingCount())

    fun runGame() {
        startGame()
        endGame(raceManager.cars)
    }

    private fun startGame() {
        val result = raceManager.race()
        output.printRaceResult(result)
    }

    private fun endGame(cars: List<Car>) {
        output.printWinner(raceManager.getWinner(cars))
    }
}
