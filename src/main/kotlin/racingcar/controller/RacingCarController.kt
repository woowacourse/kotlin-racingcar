package racingcar.controller

import racingcar.service.ForwardService
import racingcar.service.RandomGenerator
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
        outputView.printProcessStepMessage()

        tryCount.forEach {
            processStep()
        }

        val winnerService = WinnerService()
        val winners = winnerService.getWinners(cars)
        outputView.printWinners(winners)
    }

    private fun processStep() {
        val forwardService = ForwardService()
        val randomGenerator = RandomGenerator()

        cars.forEach { car ->
            val randomNumber = randomGenerator.generate()
            forwardService.tryForwardCar(car, randomNumber)
        }
        outputView.printProcessStep(cars)
    }
}
