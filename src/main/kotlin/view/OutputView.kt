package view

import model.Car

object OutputView {
    fun printMessage(message: String) {
        println(message)
    }

    fun printRaceState(cars: List<Car>) {
        cars.forEach { println("${it.name} : ${FORWARD_SIGN.repeat(it.position)}") }
        println()
    }

    fun printWinner(winners: List<String>) {
        println("최종 우승자 : ${winners.joinToString(WINNER_DELIMITER)}")
    }

    private const val WINNER_DELIMITER = ", "
    private const val FORWARD_SIGN = "-"
}
