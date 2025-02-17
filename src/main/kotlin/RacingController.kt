import model.Car
import model.CarCreator
import model.RacingGame
import model.RandomNumberGenerator
import view.InputView
import view.OutputView

class RacingController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    fun run() {
        val cars: List<Car> = generateCar()
        val racingGame = RacingGame(RandomNumberGenerator(), cars)

        val raceRound: Int = getRaceRounds()
        runRace(racingGame, raceRound)

        val winners = racingGame.getWinners()
        printRaceWinner(winners)
    }

    private fun generateCar(): List<Car> {
        val carNameInput = inputView.inputCarName()
        return CarCreator().createCars(carNameInput)
    }

    private fun getRaceRounds(): Int {
        return inputView.inputRacingCount()
    }

    private fun runRace(
        racingGame: RacingGame,
        round: Int,
    ) {
        outputView.printResultMessage()
        val raceStates = racingGame.repeatRacing(round)
        raceStates.forEach { outputView.printRaceState(it) }
    }

    private fun printRaceWinner(winners: List<String>) {
        outputView.printWinner(winners)
    }
}
