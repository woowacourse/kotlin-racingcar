package racingcar.controller

import racingcar.domain.RacingGame
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    private lateinit var racingGame: RacingGame

    fun startRacingGame() {
        racingGame = RacingGame(inputView.readCarNames(), inputView.readTryCount())
        racingGame.doWholeRace()
        outputView.showRaceInfo(racingGame.raceInfo)
        outputView.showFinalWinner(racingGame.getWinCarNames())
    }
}
