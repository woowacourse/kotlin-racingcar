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

    fun outputErrorMessage(error: String) {
        println(error)
    }

    fun outputResult(cars: Cars) {
        cars.cars.forEach {
            outputCarResult(it)
        }
        println()
    }

    fun outputCarResult(car: Car) {
        print(car.name + CAR_SEPARATE_MARK)
        repeat(car.position) { print(CAR_MOVE_MARK) }
        println()
    }

    fun outputWinners(winners: List<String>) {
        println(Constants.OUTPUT_WINNER + winners.joinToString(separator = WINNERS_SEPARATE_MARK))
    }

    companion object {
        const val CAR_SEPARATE_MARK = " : "
        const val CAR_MOVE_MARK = "-"
        const val WINNERS_SEPARATE_MARK = ", "
    }
}
