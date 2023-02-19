package racingcar.view

import racingcar.domain.Car
import racingcar.domain.Cars

class OutputView {

    fun printRoundResult(cars: Cars) {
        cars.cars.forEach { car ->
            println("$car : ${car.getPositionAsDash()}")
        }
        println()
    }

    fun printRunResult() {
        println()
        println(ROUNDS_RESULT_NOTIFICATION_MESSAGE)
    }

    fun printWinners(winners: List<Car>) {
        println("$WINNER_NOTIFICATION_MESSAGE: ${winners.joinToString(", ")}")
    }

    companion object {
        private const val ROUNDS_RESULT_NOTIFICATION_MESSAGE = "실행 결과"
        private const val WINNER_NOTIFICATION_MESSAGE = "최종 우승자"
    }
}
