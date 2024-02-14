package racingcar.controller

import racingcar.model.Car
import racingcar.model.MoveManager
import racingcar.view.InputView
import racingcar.view.OutputView

object RacingController {
    private val manager = MoveManager()
    private lateinit var currentRacingStatus: List<Car>
    fun start() {
        OutputView.printInputCarNamesMessage()
        val names = InputView.readNames()

        OutputView.printInputTrialNumMessage()
        val trialNum = InputView.readTrialNum()

        currentRacingStatus = names.map { Car(it) }

        OutputView.printTrialResultMessage()
        repeat(trialNum) {
            play()
        }
        OutputView.printFinalWinners(getWinners())
    }

    private fun play() {
        currentRacingStatus.map {
            if (manager.isMoveAble()) it.position++
            OutputView.printCurrentPosition(it.name, it.position)
        }
        println()
    }

    private fun getWinners(): List<String> {
        val maxPosition = currentRacingStatus.maxBy { it.position }.position
        return currentRacingStatus.filter { it.position == maxPosition }.map { it.name }
    }
}