package racingcar.view

import racingcar.domain.Car
import java.util.StringJoiner

fun requestCarNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)")
    return readLine()!!.split(",")
}

fun requestTotalRounds(): Int {
    println("시도할 회수는 몇 회인가요?")
    return Integer.parseInt(readLine()!!)
}

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
