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
    fun run() {
        val cars: List<Car> = generateCar()
        val racingGame = RacingGame(RandomNumberGeneratorImpl(), cars)

        val raceRound: String = getRaceRounds()
        runRace(racingGame, raceRound)

        val winners = racingGame.getWinners()
        printRaceWinner(winners)
    }

    private fun generateCar(): List<Car> {
        val carNameInput = inputView.inputCarName()
        return CarCreator().createCars(carNameInput)
    }

    private fun getRaceRounds(): String {
        return inputView.inputRacingCount()
    }

    private fun runRace(
        racingGame: RacingGame,
        round: String,
    ) {
        outputView.printResultMessage()
        racingGame.runRace(round)
    }

    private fun printRaceWinner(winners: List<String>) {
        outputView.printWinner(winners)
    }
}
