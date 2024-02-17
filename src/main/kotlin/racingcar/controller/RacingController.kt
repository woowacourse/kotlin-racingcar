package racingcar.controller

import racingcar.model.Car
import racingcar.model.RacingStatusManager
import racingcar.view.InputView
import racingcar.view.OutputView

object RacingController {
    private lateinit var racingStatusManager: RacingStatusManager

    fun start() = with(OutputView) {
        val names = getValidNames()
        val trialNum = getValidTrial()

        initializeCars(names)

        printTrialResultMessage()
        repeat(trialNum) { play() }

        printFinalWinners(getWinners())
    }

    private fun getValidNames(): List<String> {
        OutputView.printInputCarNamesMessage()
        return InputView.readNames()
    }

    private fun getValidTrial(): Int {
        OutputView.printInputTrialNumMessage()
        return InputView.readTrialNum()
    }

    private fun initializeCars(names: List<String>) {
        racingStatusManager = RacingStatusManager(cars = names.map { Car(it) })
    }

    private fun play() {
        racingStatusManager.also { statusManager ->
            statusManager.setRacingResult()
            showCurrentRacingStatus(statusManager.currentRacingStatus)
        }
    }

    private fun showCurrentRacingStatus(currentRacingStatus: List<Car>) {
        currentRacingStatus.forEach { car ->
            OutputView.apply {
                printCurrentPosition(car.name, car.position)
                if (car == currentRacingStatus.last()) printEmptyLine()
            }
        }
    }

    private fun getWinners(): List<String> {
        val currentRacingStatus = racingStatusManager.currentRacingStatus
        val maxPosition = currentRacingStatus.maxBy { it.position }.position

        return currentRacingStatus.filter { it.position == maxPosition }.map { it.name }
    }
}
