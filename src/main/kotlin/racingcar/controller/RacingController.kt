package racingcar.controller

import racingcar.model.*
import racingcar.view.InputView
import racingcar.view.OutputView

object RacingController {
    private lateinit var racingStatusManager: RacingStatusManager
    private lateinit var numberGenerator: NumberGenerator
    private lateinit var movementDecisionMaker: MovementDecisionMaker

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
        numberGenerator = RandomNumberGenerator()
        movementDecisionMaker = ThresholdMovementDecisionMaker()
        racingStatusManager = RacingStatusManager(
            cars = names.map { Car(it) },
            getNumber = numberGenerator::getNumber,
            isMovable = movementDecisionMaker::isMovable
        )
    }

    private fun play() {
        racingStatusManager.also { statusManager ->
            showCurrentRacingStatus(statusManager.getRacingStatus())
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
