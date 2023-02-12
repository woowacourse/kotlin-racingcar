package racingcar.controller

import racingcar.domain.RaceManager
import racingcar.racingcar.domain.Cars
import racingcar.racingcar.domain.RaceInfo
import racingcar.racingcar.domain.raceresult.toDto
import racingcar.view.InputView
import racingcar.view.OutputView

class GameController(
    private val raceManager: RaceManager,
) {
    private val input by lazy { InputView() }
    private val output by lazy { OutputView() }

    fun runGame() {
        val raceInfo = initGame()
        startGame(raceInfo)
        endGame(raceInfo)
    }

    private fun initGame(): RaceInfo {
        return RaceInfo(Cars(input.inputCarNames()), input.inputRacingCount())
    }

    private fun startGame(raceInfo: RaceInfo) {
        val raceResult = raceManager.race(raceInfo.cars, raceInfo.racingCount)
        output.printRaceResult(raceResult.toDto())
    }

    private fun endGame(raceInfo: RaceInfo) {
        output.printWinner(raceManager.getWinners(raceInfo.cars))
    }
}
