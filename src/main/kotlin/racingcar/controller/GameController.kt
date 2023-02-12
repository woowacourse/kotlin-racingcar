package racingcar.controller

import racingcar.domain.RaceManager
import racingcar.racingcar.domain.Cars
import racingcar.racingcar.domain.raceresult.toDto
import racingcar.view.InputView
import racingcar.view.OutputView

class GameController(
    private val raceManager: RaceManager,
) {
    private val input by lazy { InputView() }
    private val output by lazy { OutputView() }

    private var cars = Cars(listOf())
    private var racingCount = 0

    fun runGame() {
        initGame()
        startGame()
        endGame()
    }

    private fun initGame() {
        cars = Cars(input.inputCarNames())
        racingCount = input.inputRacingCount()
    }

    private fun startGame() {
        val raceResult = raceManager.race(cars, racingCount)
        output.printRaceResult(raceResult.toDto())
    }

    private fun endGame() {
        output.printWinner(raceManager.getWinners(cars))
    }
}
