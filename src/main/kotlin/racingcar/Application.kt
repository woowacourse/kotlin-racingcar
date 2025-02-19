package racingcar

import racingcar.controller.RaceController
import racingcar.util.RandomGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    val randomGenerator = RandomGenerator()

    val raceController = RaceController(inputView, outputView, randomGenerator)

    raceController.hostRace()
}
