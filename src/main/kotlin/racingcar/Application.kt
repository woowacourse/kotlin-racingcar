package racingcar

import racingcar.controller.RacingCarController
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val controller = RacingCarController(inputView, outputView)
    controller.start()
}
