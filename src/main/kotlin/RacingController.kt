import model.Car
import model.Cars
import util.Constants
import view.InputView
import view.OutputView

class RacingController {
    fun start() {
        val carInput = InputView.readCars()
        val cars = generateCars(carInput)
        val count = InputView.readCount()
        race(cars, count)
        val winner = cars.getWinners()
        OutputView.printWinner(winner)
    }

    private fun generateCars(carNames: List<String>): Cars {
        val cars = Cars()
        carNames.map { cars.add(Car(it)) }
        return cars
    }

    private fun playRound(cars: Cars) {
        cars.cars.forEach { car ->
            val randomNumber = (Constants.CONDITION_RANDOM_MIN..Constants.CONDITION_RANDOM_MAX).random()
            car.move(randomNumber)
            OutputView.printRound(car)
        }
    }

    private fun race(cars: Cars, count: Int) {
        OutputView.printResultHeader()
        repeat(count) {
            playRound(cars)
            println()
        }
    }
}
