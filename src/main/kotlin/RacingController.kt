import model.Car
import model.GenerateCar
import model.RacingGame
import model.RandomNumberGeneratorImpl
import view.InputView
import view.OutputView

class RacingController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    private lateinit var cars: List<Car>
    private lateinit var racingGame: RacingGame

    fun run() {
        generateCar()
        racingGame = RacingGame(RandomNumberGeneratorImpl(), cars)
        val round: String = getRaceRounds()
        tryRacing(round)
        val winners: List<String> = getWinner()
        printWinner(winners)
    }

    private fun generateCar() {
        val rawInput = inputView.inputCarName()
        cars = GenerateCar().generateCar(rawInput)
    }

    private fun getRaceRounds(): String {
        val rawCount = inputView.inputRacingCount()
        return rawCount
    }

    private fun tryRacing(round: String) {
        val result = racingGame.tryRacing(round)
        outputView.printRaceState(result)
    }

    private fun getWinner(): List<String> {
        return racingGame.getWinners()
    }

    private fun printWinner(winners: List<String>) {
        outputView.printWinner(winners)
    }
}
