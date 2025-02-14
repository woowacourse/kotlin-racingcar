package racingcar.controller

import racingcar.domain.Race
import racingcar.utils.Validator
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingGameController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val validator = Validator()

    fun run() {
        val rawCarNames = inputView.insertCarNames()
        validator.validateCarName(rawCarNames)
        val rawTryCount = inputView.insertTryCount()
        validator.validateTryCount(rawTryCount)
        val gameResult = playing(rawCarNames, rawTryCount)

        printGameResult(gameResult)
    }

    private fun playing(
        rawCarNames: String,
        rawTryCount: String,
    ): Race {
        val race = Race(rawCarNames, rawTryCount)
        race.getPositions()
        return race
    }

    private fun printGameResult(gameResult: Race) {
        outputView.printRoundResult(
            gameResult.cars.map { it.carName },
            gameResult.cars.map { it.position },
            gameResult.tryCount,
        )
        outputView.printWinners(gameResult.getWinners())
    }
}
