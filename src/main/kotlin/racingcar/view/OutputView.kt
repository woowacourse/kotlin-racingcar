package racingcar.view

import racingcar.domain.Car
import java.util.StringJoiner

fun printRoundResultText() {
    println("실행결과")
}

fun printRoundResult(cars: List<Car>) {
    for (car in cars) {
        printCarNameCurrentPosition(car)
    }
    println()
}

private fun printCarNameCurrentPosition(car: Car) {
    val sb = StringBuilder()
    sb.append(car.name).append(" : ")
    for (i in 1..car.position) {
        sb.append("-")
    }
    println(sb.toString())
}

fun printWinners(winners: List<Car>) {
    val joiner = StringJoiner(", ")
    for (winner in winners) {
        joiner.add(winner.name)
    }
    val winnerNames = joiner.toString()
    println("${winnerNames}가 최종 우승했습니다.")
}
