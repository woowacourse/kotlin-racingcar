package racingcar

import racingcar.controller.RacingGameController
import racingcar.domain.strategy.RandomNumberGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    RacingGameController(InputView(), OutputView(), RandomNumberGenerator()).run()
}
