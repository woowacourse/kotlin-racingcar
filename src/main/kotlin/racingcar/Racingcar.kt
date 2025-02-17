package racingcar

import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val racingController = RacingController(InputView, OutputView)
    racingController.start()
}
