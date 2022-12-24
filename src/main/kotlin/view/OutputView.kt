package view

import domain.Car

private const val POSITION_BAR = "-"
private const val LINE_DELIMITER = "="

fun printErrorMessage(message: String) {
    println(message)
}

fun printCarsPosition(cars: List<Car>) {
    println("\n${LINE_DELIMITER.repeat(20)}\n")
    cars.forEach { println("${it.name.value}: ${POSITION_BAR.repeat(it.position.value)}") }
}

fun printWinners(winners: List<Car>) {
    println("\n${LINE_DELIMITER.repeat(20)}\n")
    val winnerNames = winners.map { it.name.value }
    println("우승자는 ${winnerNames.joinToString(", ")} 입니다!")
}
