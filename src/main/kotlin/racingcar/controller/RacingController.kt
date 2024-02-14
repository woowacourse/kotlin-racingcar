package racingcar.controller

import racingcar.model.Car
import racingcar.model.MoveManager
import racingcar.view.InputView
import racingcar.view.OutputView

object RacingController {
    private val manager = MoveManager()
    fun start() {
        OutputView.printInputCarNamesMessage()
        val names = InputView.readNames()

        OutputView.printInputTrialNumMessage()
        val trialNum = InputView.readTrialNum()

        val cars = names.map { Car(it) }

        OutputView.printTrialResultMessage()
        repeat(trialNum) {
            play(cars)
        }
        OutputView.printFinalWinnersMessage()
    }

    private fun play(cars: List<Car>) {
        cars.map {
            if (manager.isMoveAble()) it.position++
            OutputView.printCurrentPosition(it.name, it.position)
        }
        println()
    }
}