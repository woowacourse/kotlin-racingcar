package racingcar

import racingcar.model.Car
import racingcar.util.Constants
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController {
    private val inputView = InputView()
    private val outputView = OutputView

    fun generateCarList(carsInput: List<String>): List<Car> {
        return carsInput.map { Car(it) }
    }

    fun playRound(cars: List<Car>) {
        cars.forEach { car ->
            val number = (Constants.CONDITION_RANDOM_MIN..Constants.CONDITION_RANDOM_MAX).random()
            car.move(number)
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
        val carInput = inputView.readCars()
        val cars = generateCarList(carInput)
        val count = inputView.readCount()
        race(count, cars)
        val winner = getWinner(cars)
        outputView.printWinner(winner)
    }
}
