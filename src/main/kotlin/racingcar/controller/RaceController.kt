package racingcar.controller

import racingcar.domain.Race
import racingcar.utils.ErrorHandler.validCarName
import racingcar.utils.ErrorHandler.validTryCount
import racingcar.view.InputView
import racingcar.view.OutputView

class RaceController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        val values = getCars()
        val gameResult = runRace(values)

        printGameResult(gameResult)
    }

    private fun getCars(): Pair<String, String> {
        val rawCarNames = inputView.insertCarNames().validCarName()
        val rawTryCount = inputView.insertTryCount().validTryCount()
        return rawCarNames to rawTryCount
    }

    private fun runRace(values: Pair<String, String>): Race {
        val race = Race(values.first, values.second)
        race.moveOrStops()
        return race
    }

    private fun printGameResult(gameResult: Race) {
        outputView.printRoundResult(gameResult.cars.map { it.carName }, gameResult.cars.map { it.moveOrStop }, gameResult.tryCount)
        outputView.printWinners(gameResult.getWinners())
    }
}
