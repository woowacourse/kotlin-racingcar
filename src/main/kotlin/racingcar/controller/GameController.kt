package racingcar.controller

import racingcar.domain.RacingManager
import racingcar.domain.RandomNumberGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

class GameController {
    private val input by lazy { InputView() }
    private val output by lazy { OutputView() }
    private lateinit var racingManager: RacingManager

    fun startGame() {
        racingManager = RacingManager(RandomNumberGenerator())
        racingManager.setGame(input.inputCarNames(), input.inputRacingCount())
        output.printResult()
        while (!racingManager.checkGameIsOver()) {
            output.printCarsState(racingManager.race())
        }
        output.printWinner(racingManager.getWinner())
    }
}
