package view

import domain.cars.Cars
import java.lang.String.format

class OutputView {
    fun showResult() {
        println(Constants.OUTPUT_RESULT_MESSAGE)
    }

    fun showStatus(cars: Cars) {
        println(cars.toString())
    }

    fun showWinners(winnerNames: String) {
        println(format(Constants.OUTPUT_FINAL_WINNER_MESSAGE_FORMAT, winnerNames))
    }
}
