package racingcar

import racingcar.controller.RacingCarController
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    RacingCarController(InputView(), OutputView()).run()
}
