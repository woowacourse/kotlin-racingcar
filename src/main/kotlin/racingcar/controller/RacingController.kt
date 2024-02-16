package racingcar.controller

import racingcar.model.Car
import racingcar.model.MoveManager
import racingcar.model.RandomNumberGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

object RacingController {
    private val manager = MoveManager()
    private val numberGenerator = RandomNumberGenerator()
    private lateinit var currentRacingStatus: List<Car>
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
        currentRacingStatus = names.map { Car(it) }
    }

    private fun play() {
        currentRacingStatus = currentRacingStatus.map {
            it.takeIf { manager.isMoveAble(numberGenerator.getRandomNumber()) }?.getMoveStepResult() ?: it
        }

        currentRacingStatus.forEachIndexed { index, car ->
            OutputView.apply {
                printCurrentPosition(car.name, car.position)
                if (index == currentRacingStatus.size - 1) printEmptyLine()
            }
        }
    }

    private fun getWinners(): List<String> {
        val maxPosition = currentRacingStatus.maxBy { it.position }.position
        return currentRacingStatus.filter { it.position == maxPosition }.map { it.name }
    }
}