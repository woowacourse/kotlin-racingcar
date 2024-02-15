package racingcar

import racingcar.controller.CarController
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val carController = CarController(
        inputView = InputView(),
        outputView = OutputView(),
        validator = Validator()
    )
    carController.run()
}
