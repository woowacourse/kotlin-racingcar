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
        val rawCarNames = inputView.insertCarNames().validCarName()
        val rawTryCount = inputView.insertTryCount().validTryCount()

        val race = Race(rawCarNames, rawTryCount)
        race.moveOrStops()
        val winners = race.getWinners()

        outputView.printRoundResult(race.cars.map { it.carName }, race.cars.map { it.moveOrStop }, race.tryCount)
        outputView.printWinners(winners)
    }
}
