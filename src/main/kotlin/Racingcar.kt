import model.Car
import util.Constants
import view.InputView
import view.OutputView

fun main() {

    fun generateCarList(carsInput: List<String>): MutableList<Car> {
        val cars = mutableListOf<Car>()
        carsInput.map { cars.add(Car(it, 0)) }

        return cars
    }

    fun moveCars(cars: List<Car>) {
        cars.forEach { car ->
            val number = (Constants.CONDITION_RANDOM_MIN..Constants.CONDITION_RANDOM_MAX).random()
            if (number >= Constants.CONDITION_MOVE_THRESHOLD) car.position++
            OutputView.printRound(car)
        }
    }

    fun race(count: Int, cars: List<Car>) {
        OutputView.printResultHeader()
        repeat(count) {
            moveCars(cars)
            println()
        }
    }

    fun getWinner(cars: List<Car>): MutableList<String> {
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

    start()
}