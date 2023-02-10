package racingcar.controller

import racingcar.domain.RacingManager
import racingcar.view.InputView
import racingcar.view.OutputView

class GameController(
    private val racingManager: RacingManager,
) {
    private val input by lazy { InputView() }
    private val output by lazy { OutputView() }

    fun runGame() {
        initGame()
        startGame()
        endGame()
    }

    private fun initGame() {
        racingManager.setGame(input.inputCarNames(), input.inputRacingCount())
    }

    private fun startGame() {
        output.printResult()
        while (!racingManager.isOver()) {
            val cars = racingManager.race()
            output.printCarsState(cars)
        }
    }

    private fun endGame() {
        output.printWinner(racingManager.getWinner())
    }
}
