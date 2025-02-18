package racingcar

import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val racingController = RacingController(inputView, outputView)
    racingController.start()
}
