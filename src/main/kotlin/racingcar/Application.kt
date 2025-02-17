package racingcar

import racingcar.controller.RacingCarController
import racingcar.model.random.RandomNumberGenerator
import racingcar.model.random.RandomNumberGeneratorImpl
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val randomNumberGenerator: RandomNumberGenerator = RandomNumberGeneratorImpl()
    val controller = RacingCarController(inputView, outputView, randomNumberGenerator)
    controller.start()
}
