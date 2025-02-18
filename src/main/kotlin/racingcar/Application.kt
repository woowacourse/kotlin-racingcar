package racingcar

import racingcar.controller.RaceController
import racingcar.view.InputReader
import racingcar.view.OutputPrinter

fun main() {
    val inputReader = InputReader()
    val outputPrinter = OutputPrinter()

    val raceController = RaceController(inputReader, outputPrinter)

    raceController.hostRace()
}
