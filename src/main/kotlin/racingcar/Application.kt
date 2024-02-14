package racingcar

import racingcar.controller.RacingCarController
import racingcar.view.input.InputView
import racingcar.view.output.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val racingCarController = RacingCarController(inputView, outputView)
    racingCarController.run()
}