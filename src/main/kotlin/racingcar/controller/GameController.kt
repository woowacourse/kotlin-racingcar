package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.RaceManager
import racingcar.racingcar.domain.RaceResultDto
import racingcar.view.InputView
import racingcar.view.OutputView

class GameController(
    private val raceManager: RaceManager,
) {
    private val input by lazy { InputView() }
    private val output by lazy { OutputView() }

    fun runGame() {
        initGame()
        val result = startGame()
        endGame(result.cars)
    }

    private fun initGame() {
        raceManager.setGame(input.inputCarNames(), input.inputRacingCount())
    }

    private fun startGame(): RaceResultDto {
        val result = raceManager.race()
        output.printRaceResult(result)
        return result
    }

    private fun endGame(cars: List<Car>) {
        output.printWinner(raceManager.getWinner(cars))
    }
}
