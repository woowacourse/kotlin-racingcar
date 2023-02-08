package racingcar.view

import racingcar.domain.Car
import racingcar.resources.OUTPUT_RESULT_MESSAGE

class OutputView {
    fun printCarsState(cars: List<Car>) {
        cars.forEach { car -> printCarState(car) }
        println()
    }

    private fun printCarState(car: Car) {
        print("${car.name} : ")
        println("-".repeat(car.location))
    }

    fun printResult() {
        println(OUTPUT_RESULT_MESSAGE)
    }
}
