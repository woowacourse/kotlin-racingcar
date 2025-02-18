package racingcar

import racingcar.controller.RaceController
import racingcar.ui.InputReader
import racingcar.ui.OutputPrinter

fun main() {
    val inputReader = InputReader()
    val outputPrinter = OutputPrinter()

    val raceController = RaceController(inputReader, outputPrinter)

    raceController.hostRace()
}
