package racingCar

import racingCar.controller.RacingGameController
import racingCar.view.InputView
import racingCar.view.OutputView

fun main() {
    val controller = RacingGameController(InputView(), OutputView())
    controller.start()
}
