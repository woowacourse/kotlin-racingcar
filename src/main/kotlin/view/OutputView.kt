package view

import model.Car
import model.Cars
import util.Constants

class OutputView {

    fun outputCarNames() {
        println(Constants.INPUT_CAR_NAME)
    }

    fun outputTryNumber() {
        println(Constants.INPUT_TRY_NUMBER)
    }

    fun outputResults() {
        println()
        println(Constants.OUTPUT_RESULT)
    }

    fun outputErrorMessage(error: IllegalArgumentException) {
        println(error.message)
    }

    fun outputResult(cars: Cars) {
        cars.cars.forEach {
            outputCarResult(it)
        }
        println()
    }

    fun outputCarResult(car: Car) {
        print(car.name + " : ")
        repeat(car.position) { print("-") }
        println()
    }

    fun outputWinners(winners: List<String>) {
        println(Constants.OUTPUT_WINNER + winners.joinToString(separator = ", "))
    }
}
