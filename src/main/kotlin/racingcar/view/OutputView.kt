package racingcar.view

import racingcar.model.car.Car

class OutputView {
    fun printMessage(message: String) = println(message)

    fun printRoundResult(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.carName.name} : ${getPositionAsDash(car.position)}")
        }
        println()
    }

    fun printWinners(winners: List<Car>) {
        println("$WINNER_NOTIFICATION_MESSAGE: ${winners.joinToString(", ") { it.carName.name }}")
    }

    private fun getPositionAsDash(position: Int): String = DASH.repeat(position)

    companion object {
        private const val WINNER_NOTIFICATION_MESSAGE = "최종 우승자"
        private const val DASH = "-"
    }
}
