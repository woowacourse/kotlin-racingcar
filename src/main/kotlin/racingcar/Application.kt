package racingcar

import racingcar.controller.RacingGameController
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val racingGameController = RacingGameController(InputView(), OutputView())
    racingGameController.run()
}
