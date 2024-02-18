package racingcar.view

import racingcar.model.Car

object OutputView {

    fun outputStartGame() {
        println()
        println(RESULT_START)
    }

    fun outputRoundResults(cars: List<Car>) {
        cars.forEach { car ->
            println(ROUND_RESULT.format(car.getName(), PROGRESS_BAR.repeat(car.getStep())))
        }
        println()
    }

    fun outputWinners(winners: List<String>) {
        println(FINAL_WINNERS.format(winners.joinToString(SEPARATOR)))
    }

    private const val PROGRESS_BAR = "-"
    private const val SEPARATOR = ", "
    private const val RESULT_START = "실행 결과"
    private const val ROUND_RESULT = "%s : %s"
    private const val FINAL_WINNERS = "최종 우승자: %s"
}
