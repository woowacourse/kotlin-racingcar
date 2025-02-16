package racingcar.controller

import racingcar.domain.RacingGame
import racingcar.view.InputView

class RacingController(
    private val inputView: InputView,
) {
    private lateinit var racingGame: RacingGame

    fun run() {
        racingGame = RacingGame()
        initializeRacingGame()
    }

    private fun initializeRacingGame() {
        racingGame.initializeCars(inputView.readCarNames())
    }
}
