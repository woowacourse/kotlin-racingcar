import model.Car
import model.Cars
import view.InputView
import view.OutputView

class RacingController {
    fun run() {
        val carNames = InputView.readCarNames()
        val cars = generateCars(carNames)
        val count = InputView.readCount()
        playRace(cars, count)
        val winner = cars.getWinners()
        OutputView.printWinner(winner)
    }

    private fun generateCars(carNames: List<String>): Cars {
        val cars = Cars()
        carNames.map { cars.add(Car(it)) }
        return cars
    }

    private fun playRace(cars: Cars, count: Int) {
        OutputView.printResultHeader()
        repeat(count) {
            cars.playRound()
            println()
        }
    }
}
