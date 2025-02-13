import model.RacingGame
import model.RandomNumberGeneratorImpl
import view.InputView
import view.OutputView

class RacingController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    private var racingGame: RacingGame

    init {
        val randomNumberGeneratorImpl = RandomNumberGeneratorImpl()
        racingGame = RacingGame(randomNumberGeneratorImpl)
    }

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
