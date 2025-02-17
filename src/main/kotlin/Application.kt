import controller.RaceController
import ui.InputReader
import ui.OutputPrinter

fun main() {
    val inputReader = InputReader()
    val outputPrinter = OutputPrinter()

    val raceController = RaceController(inputReader, outputPrinter)

    raceController.hostRace()
}
