package racingcar.controller

import racingcar.view.InputView

class CarController(
    private val inputView: InputView
) {

    fun run() {

    }

    fun registerCars() {
        val cars = inputView.inputCarNames()

    }
}
