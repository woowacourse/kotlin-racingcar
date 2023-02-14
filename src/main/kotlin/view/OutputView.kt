package view

import model.Car
import util.Constants

class OutputView {

    fun outputCarNames() {
        println(Constants.INPUT_CAR_NAME)
    }

    fun outputNumber() {
        println(Constants.INPUT_NUMBER)
    }

    fun outputResults() {
        println()
        println(Constants.OUTPUT_RESULT)
    }

    fun outputNextLine() {
        println()
    }

    fun outputErrorMessage(error: String) {
        println(error)
    }

    fun outputResult(car: Car) {
        print(car.name + " : ")
        repeat(car.position) {
            print("-")
        }
        println()
    }

    fun outputWinners(winners: List<String>) {
        println(Constants.OUTPUT_WINNER + winners.joinToString(separator = ", "))
    }
}
