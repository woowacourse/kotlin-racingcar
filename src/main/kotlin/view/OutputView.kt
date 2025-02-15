package view

import domain.cars.Cars
import java.lang.String.format

class OutputView {
    fun showResult() {
        println(OUTPUT_RESULT_MESSAGE)
    }

    fun showStatus(cars: Cars) {
        println(cars.toString())
    }

    fun showWinners(winnerNames: String) {
        println(format(OUTPUT_FINAL_WINNER_MESSAGE_FORMAT, winnerNames))
    }

    companion object {
        const val OUTPUT_RESULT_MESSAGE = "\n실행 결과"
        const val OUTPUT_FINAL_WINNER_MESSAGE_FORMAT = "최종 우승자: %s"
    }
}
