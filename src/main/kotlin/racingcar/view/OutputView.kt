package racingcar.view

import racingcar.model.Car

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

    private fun getPositionAsDash(position: Int): String = DASH.repeat(position)

    companion object {
        const val WINNER_NOTIFICATION_MESSAGE = "최종 우승자"
        const val DASH = "-"
    }
}
