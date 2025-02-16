package racingcar

import racingcar.controller.RacingController
import racingcar.view.InputView

fun main() {
    val inputView = InputView()
    RacingController(inputView).run()
}
