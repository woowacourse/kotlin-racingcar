package racingcar

import racingcar.controller.RaceController
import racingcar.util.RandomGenerator
import racingcar.view.InputReader
import racingcar.view.OutputPrinter

fun main() {
    val inputReader = InputReader()
    val outputPrinter = OutputPrinter()

    val randomGenerator = RandomGenerator()

    val raceController = RaceController(inputReader, outputPrinter, randomGenerator)

    raceController.hostRace()
}
