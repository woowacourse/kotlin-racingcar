package racingcar.view

import racingcar.model.Car

class OutputView {
    fun printResultTitle() = println(MESSAGE_ROUND_RESULT)

    fun printRoundResult(cars: List<Car>) {
        cars.forEach { car -> println(car) }
        println()
    }

    fun printWinners(winners: List<Car>) = println("$MESSAGE_WINNER ${winners.joinToString(", ") { it.name }}")

    companion object {
        const val MESSAGE_ROUND_RESULT = "\n실행 결과"
        const val MESSAGE_WINNER = "최종 우승자:"
    }
}
