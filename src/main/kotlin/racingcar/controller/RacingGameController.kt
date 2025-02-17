package racingcar.controller

import racingcar.domain.Race
import racingcar.utils.InputValidator
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingGameController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val validator = InputValidator()

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
        return race
    }

    private fun printGameResult(gameResult: Race) {
        val roundPositions = gameResult.getPositions()
        outputView.printRoundResult(
            gameResult.cars.map { it.carName },
            roundPositions,
        )
        outputView.printWinners(gameResult.getWinners())
    }
}
