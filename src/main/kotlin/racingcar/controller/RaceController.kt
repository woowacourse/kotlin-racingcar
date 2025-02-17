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
        val (carNames, tryCount) = getCars()
        val race = Race(carNames, tryCount)

        println(RUNNING_RESULT_MESSAGE)

        repeat(race.tryCount) {
            race.runRound()
            outputView.printRoundResult(race.cars)
        }

        outputView.printWinners(race.getWinners())
    }

    private fun getCars(): Pair<String, String> {
        val rawCarNames = inputView.insertCarNames().validCarName()
        val rawTryCount = inputView.insertTryCount().validTryCount()
        return rawCarNames to rawTryCount
    }

    companion object {
        private const val RUNNING_RESULT_MESSAGE = "\n실행 결과"
    }
}
