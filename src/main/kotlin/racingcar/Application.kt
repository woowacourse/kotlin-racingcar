package racingcar

import racingcar.controller.RacingController
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    RacingController(inputView, outputView).startRacingGame()
}
