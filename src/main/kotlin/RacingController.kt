import model.RacingGame
import view.InputView
import view.OutputView

class RacingController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    private val racingGame = RacingGame()

    fun run() {
        inputCarNames()
        inputRacingCount()
        printRacingWinner()
    }

    private fun inputCarNames() {
        val rawInput = inputView.inputCarName()
        racingGame.generateCars(rawInput)
    }

    private fun inputRacingCount() {
        val rawCount = inputView.inputRacingCount()

        val result = racingGame.tryRacing(rawCount)
        outputView.printResult(result)
    }

    private fun printRacingWinner() {
        val result = racingGame.calculateWinner()
        outputView.printWinner(result)
    }
}
