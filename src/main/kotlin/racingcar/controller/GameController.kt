package racingcar.controller

import racingcar.domain.RacingManager
import racingcar.domain.RandomNumberGenerator
import racingcar.view.InputView

class GameController {
    private val input by lazy { InputView() }
    private lateinit var racingManager: RacingManager

    fun startGame() {
        racingManager = RacingManager(RandomNumberGenerator())
        racingManager.setGame(input.inputCarNames(), input.inputRacingCount())
        while (!racingManager.checkGameIsOver()) {
            racingManager.race()
        }
    }
}
