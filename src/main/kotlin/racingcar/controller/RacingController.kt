package racingcar.controller

import racingcar.domain.RacingGame
import racingcar.domain.strategy.RandomMoveStrategy
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    private lateinit var racingGame: RacingGame
    private val moveStrategy = RandomMoveStrategy()

    fun startRacingGame() {
        racingGame = RacingGame(inputView.readCarNames(), moveStrategy)
        runRace(inputView.readRaceCount())
        outputView.showFinalWinner(racingGame.getWinCarNames())
    }

    private fun runRace(raceCountText: String) {
        outputView.showRaceResultHeader()
        racingGame.doWholeRace(parseRaceCountTextToInt(raceCountText)) { raceResult ->
            outputView.showSingleRaceInfo(raceResult)
        }
    }

    companion object {
        private fun parseRaceCountTextToInt(text: String): Int = text.toIntOrNull() ?: throw IllegalArgumentException(ERROR_NOT_NUMBER)

        private const val ERROR_NOT_NUMBER = "입력이 숫자가 아닙니다."
    }
}
