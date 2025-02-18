package racingcar

import racingcar.controller.RacingCarController
import racingcar.model.random.NumberGenerator
import racingcar.model.random.NumberGeneratorImpl
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val numberGenerator: NumberGenerator = NumberGeneratorImpl()
    val controller = RacingCarController(inputView, outputView, numberGenerator)
    controller.start()
}
