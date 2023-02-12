package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.RaceManager
import racingcar.view.OutputView

class GameController(
    private val raceManager: RaceManager,
) {
    private val output by lazy { OutputView() }

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
