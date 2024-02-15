package racingcar.controller

import racingcar.service.ForwardService
import racingcar.service.WinnerService
import racingcar.utils.retryWhileNoException
import racingcar.view.input.InputView
import racingcar.view.output.OutputView

class RacingCarController(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    private val cars = inputCarNames()
    private val tryCount = inputTryCount()

    fun run() {
        val forwardService = ForwardService()
        tryCount.forEach {
            forwardService.processStep(cars)
            outputView.printProcessStep(cars)
        }
        
        val winnerService = WinnerService()
        val winners = winnerService.getWinners(cars)
        outputView.printWinners(winners)
    }

    private fun inputCarNames() = retryWhileNoException {
        outputView.printInputCarNamesMessage()
        inputView.readCarNames()
    }

    private fun inputTryCount() = retryWhileNoException {
        outputView.printInputTryCountMessage()
        inputView.readTryCount()
    }
}
