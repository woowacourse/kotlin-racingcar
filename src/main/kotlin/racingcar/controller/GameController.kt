package racingcar.controller

import racingcar.domain.RacingManager
import racingcar.domain.RandomNumberGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

class GameController {
    private val input by lazy { InputView() }
    private val output by lazy { OutputView() }
    private lateinit var racingManager: RacingManager

    fun runGame() {
        initGame()
        startGame()
        endGame()
    }

    private fun initGame() {
        racingManager = RacingManager(RandomNumberGenerator())
        racingManager.setGame(input.inputCarNames(), input.inputRacingCount())
    }

    private fun startGame() {
        output.printResult()
        while (!racingManager.checkGameIsOver()) {
            racingManager.race()
            output.printCarsState(racingManager.getCarNames(), racingManager.getCarLocations())
        }
    }

    private fun endGame() {
        output.printWinner(racingManager.getWinner())
    }
}
