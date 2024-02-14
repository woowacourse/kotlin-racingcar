package racingcar

import racingcar.controller.CarController
import racingcar.view.InputView

fun main() {
    val carController = CarController(
        inputView = InputView(),
        validator = Validator()
    )
    carController.run()
}
