package racingcar

import racingcar.controller.RacingCarController
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val racingCarController = RacingCarController(inputView, outputView)
    racingCarController.start()
}
