package racingcar.controller

import racingcar.service.ForwardService
import racingcar.service.RandomGenerator
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

        tryCount.forEach {
            processStep()
        }

        val winners = WinnerService.getWinners(cars)
        OutputView.printWinners(winners)
    }

    private fun processStep() {
        cars.forEach { car ->
            val randomNumber = RandomGenerator.generate()
            ForwardService.tryForwardCar(car, randomNumber)
        }
        OutputView.printProcessStep(cars)
    }
}
