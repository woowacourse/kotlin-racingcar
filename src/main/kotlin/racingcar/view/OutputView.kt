package racingcar.view

import racingcar.model.Car
import racingcar.utils.WINNER_NOTIFICATION_MESSAGE

class OutputView {
    fun printMessage(message: String) = println(message)

    fun printRoundResult(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${getPositionAsDash(car.position)}")
        }
        println()
    }

    fun printWinners(winners: List<Car>) {
        println("$WINNER_NOTIFICATION_MESSAGE: ${winners.joinToString(", ")}")
    }

    private fun getPositionAsDash(position: Int): String =
        "-".repeat(position)
}
