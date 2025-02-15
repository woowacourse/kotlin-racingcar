import model.Car
import model.CarCreator
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
        printWinner()
    }

    private fun generateCar() {
        val rawInput = inputView.inputCarName()
        cars = CarCreator().createCars(rawInput)
    }

    private fun getRaceRounds(): String {
        val rawCount = inputView.inputRacingCount()
        return rawCount
    }

    private fun tryRacing(round: String) {
        racingGame.runRace(round)
    }

    private fun printWinner() {
        val winners = racingGame.getWinners()
        outputView.printWinner(winners)
    }
}
