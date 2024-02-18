package racingcar.view

import racingcar.model.Car
import racingcar.util.OutputMessage

object OutputView {

    fun outputStartGame() {
        println()
        println(OutputMessage.RESULT_START)
    }

    fun outputRoundResults(cars: List<Car>) {
        cars.forEach { car ->
            println(OutputMessage.ROUND_RESULT.format(car.getName(), PROGRESS_BAR.repeat(car.getStep())))
        }
        println()
    }

    fun outputWinners(winners: List<String>) {
        println(OutputMessage.FINAL_WINNERS.format(winners.joinToString(", ")))
    }

    private const val PROGRESS_BAR = "-"
}
