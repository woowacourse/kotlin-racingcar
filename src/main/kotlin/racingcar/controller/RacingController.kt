package racingcar.controller

import racingcar.model.*
import racingcar.view.InputView
import racingcar.view.OutputView

object RacingController {
    private val racingGameManager = RacingGameManager()

    fun start() = with(OutputView) {
        val names = getValidNames()
        val trialNum = getValidTrial()

        racingGameManager.initializeCars(names)
        printTrialResultMessage()
        repeat(trialNum) { showCurrentRacingStatus(racingGameManager.play()) }
        printFinalWinners(racingGameManager.getWinners())
    }

    private fun getValidNames(): List<String> {
        OutputView.printInputCarNamesMessage()
        return InputView.readNames()
    }

    private fun getValidTrial(): Int {
        OutputView.printInputTrialNumMessage()
        return InputView.readTrialNum()
    }

    private fun showCurrentRacingStatus(currentRacingStatus: List<Car>) {
        currentRacingStatus.forEach { car ->
            OutputView.apply {
                printCurrentPosition(car.name, car.position)
                if (car == currentRacingStatus.last()) printEmptyLine()
            }
        }
    }
}
