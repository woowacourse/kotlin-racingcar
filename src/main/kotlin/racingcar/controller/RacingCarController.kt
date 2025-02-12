package racingcar.controller

import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun start() {
        val carNames = inputView.readCarNames()
    }
}
