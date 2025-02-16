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
        racingGame.doWholeRace()
    }

    private fun initializeRacingGame() {
        racingGame.initializeCars(inputView.readCarNames())
        racingGame.initializeRaceCount(inputView.readTryCount())
    }
}
