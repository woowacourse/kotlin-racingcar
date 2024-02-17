package racingcar.controller

import racingcar.service.RacingService
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

    private fun inputCarNames() = retryWhileNoException {
        outputView.printInputCarNamesMessage()
        inputView.readCarNames()
    }

    private fun inputTryCount() = retryWhileNoException {
        outputView.printInputTryCountMessage()
        inputView.readTryCount()
    }

    fun run() {
        processStep()
        getWinner()
    }

    private fun processStep() {
        outputView.printProcessStepMessage()
        val racingService = RacingService()
        repeat(tryCount.count) {
            val currentCars = racingService.startRace(cars)
            outputView.printProcessStep(currentCars)
        }
    }

    private fun getWinner() {
        val winnerService = WinnerService()
        val winners = winnerService.getWinners(cars)
        outputView.printWinners(winners)
    }
}
