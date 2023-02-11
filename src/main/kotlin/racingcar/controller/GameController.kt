package racingcar.controller

import racingcar.domain.RaceManager
import racingcar.view.InputView
import racingcar.view.OutputView

class GameController(
    private val raceManager: RaceManager,
) {
    private val input by lazy { InputView() }
    private val output by lazy { OutputView() }

    fun runGame() {
        initGame()
        startGame()
        endGame()
    }

    private fun initGame() {
        raceManager.setGame(input.inputCarNames(), input.inputRacingCount())
    }

    private fun startGame() {
        val result = raceManager.race()
        output.printRaceResult(result)
    }

    private fun endGame() {
        output.printWinner(raceManager.getWinner())
    }
}
