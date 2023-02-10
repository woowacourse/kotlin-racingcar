package racingcar.view

import racingcar.domain.Car
import racingcar.resources.OUTPUT_RESULT
import racingcar.resources.OUTPUT_WINNER

class OutputView {
    fun printCarsState(cars: List<Car>) {
        cars.forEach { car ->
            printCarState(car.name, car.location)
        }
        println()
    }

    private fun printCarState(carName: String, carLocation: Int) {
        println(carName + " : " + "-".repeat(carLocation))
    }

    fun printResult() {
        println(OUTPUT_RESULT)
    }

    fun printWinner(carNames: List<String>) {
        print(OUTPUT_WINNER + carNames.joinToString(", "))
    }
}
