package view

import model.Car
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

    fun outputResult(car: Car) {
        val carInfo = car.getInfo()
        print(carInfo.first + " : ")
        for (i in 1..carInfo.second) {
            print("-")
        }
        println()
    }

    fun outputWinners(winners: List<String>) {
        println(Constants.OUTPUT_WINNER + winners.joinToString(separator = ", "))
    }
}
