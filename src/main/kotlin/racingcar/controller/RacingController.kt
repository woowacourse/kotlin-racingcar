package racingcar.controller

import racingcar.model.Car
import racingcar.model.MoveManager
import racingcar.view.InputView

object RacingController {
    private val manager = MoveManager()
    fun start() {
        val names = InputView.readNames()
        val trialNum = InputView.readTrialNum()
        val cars = names.map { Car(it) }
        repeat(trialNum) {
            play(cars)
            println(cars.toString())
        }
    }

    private fun play(cars: List<Car>) {
        cars.map { if (manager.isMoveAble()) it.position++ }
    }
}