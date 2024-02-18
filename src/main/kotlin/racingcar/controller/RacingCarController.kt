package racingcar.controller

import racingcar.service.RacingGame
import racingcar.service.WinnerService
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
        OutputView.printProcessStepMessage()

        val racingGame = RacingGame(cars)
        tryCount.forEach {
            racingGame.updateCarsPosition()
            OutputView.printProcessStep(cars)
        }

        val winners = WinnerService.getWinners(cars)
        OutputView.printWinners(winners)
    }
}
