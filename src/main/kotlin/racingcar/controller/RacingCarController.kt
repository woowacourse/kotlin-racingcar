package racingcar.controller

import racingcar.service.RacingGame
import racingcar.service.RandomForwardNumberGenerator
import racingcar.utils.retryWhileNoException
import racingcar.view.input.InputView
import racingcar.view.output.OutputView

class RacingCarController {
    private val cars = inputCarNames()
    private val tryCount = inputTryCount()

    private fun inputCarNames() =
        retryWhileNoException {
            OutputView.printInputCarNamesMessage()
            InputView.readCarNames()
        }

    private fun inputTryCount() =
        retryWhileNoException {
            OutputView.printInputTryCountMessage()
            InputView.readTryCount()
        }

    fun run() {
        OutputView.printProcessResultMessage()

        val racingGame = RacingGame(cars, RandomForwardNumberGenerator)
        tryCount.forEach {
            racingGame.updateCarsPosition()
            OutputView.printCarsPosition(cars)
        }

        val winners = racingGame.getWinners()
        OutputView.printWinners(winners)
    }
}
