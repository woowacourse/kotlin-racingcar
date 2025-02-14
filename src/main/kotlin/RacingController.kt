import model.Car
import util.Constants
import view.InputView
import view.OutputView

class RacingController {
    fun generateCarList(carsInput: List<String>): List<Car> {
        val cars = mutableListOf<Car>()
        carsInput.map { cars.add(Car(it, 0)) }

        return cars
    }

    fun moveCars(
        number: Int,
        car: Car,
    ) {
        if (number >= Constants.CONDITION_MOVE_THRESHOLD) car.position++
    }

    fun playRound(cars: List<Car>) {
        cars.forEach { car ->
            val number = (Constants.CONDITION_RANDOM_MIN..Constants.CONDITION_RANDOM_MAX).random()
            moveCars(number, car)
            OutputView.printRound(car)
        }
    }

    fun race(
        count: Int,
        cars: List<Car>,
    ) {
        OutputView.printResultHeader()
        repeat(count) {
            playRound(cars)
            println()
        }
    }

    fun getWinner(cars: List<Car>): List<String> {
        val winner = mutableListOf<String>()
        cars.forEach { car ->
            if (car.position == cars.maxOf { it.position }) {
                winner.add(car.name)
            }
        }

        return winner
    }

    fun start() {
        val carInput = InputView.readCars()
        val cars = generateCarList(carInput)
        val count = InputView.readCount()
        race(count, cars)
        val winner = getWinner(cars)
        OutputView.printWinner(winner)
    }
}
