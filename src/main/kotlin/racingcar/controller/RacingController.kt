package racingcar.controller

import racingcar.model.Car
import racingcar.model.MoveManager
import racingcar.model.NumberGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController(
    private val manager: MoveManager,
    private val numberGenerator: NumberGenerator
) {
    private lateinit var currentRacingStatus: List<Car>

    fun start() =
        with(OutputView) {
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
        currentRacingStatus = names.map { Car(it) }.toMutableList()
    }

    private fun play() {
        currentRacingStatus.map { car ->
            if (manager.isMoveAble(numberGenerator.getNumber())) car.move()
        }
        OutputView.printNameAndCurrentPosition(currentRacingStatus)
    }

    private fun getWinners(): List<String> {
        val maxPosition = currentRacingStatus.maxBy { it.position }.position
        return currentRacingStatus.filter { it.position == maxPosition }.map { it.name }
    }
}
