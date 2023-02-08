package racingcar.controller

import racingcar.domain.RacingManager
import racingcar.view.InputView

class GameController {
    private val input by lazy { InputView() }
    private lateinit var racingManager: RacingManager

    fun startGame() {
        racingManager = RacingManager()
        racingManager.setGame(input.inputCarNames(), input.inputRacingCount())
    }
}
