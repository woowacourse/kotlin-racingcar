package view

import domain.Cars
import domain.Winners

object OutputView {
    private const val HEADER_RESULT = "실행 결과"
    private const val HEADER_WINNERS = "최종 우승자 :"

    fun printResultHeader() = println(HEADER_RESULT)

    fun printPhase(cars: Cars) {
        cars.cars.forEach {
            println("${it.name} :" + "-".repeat(it.position))
        }
        println()
    }

    fun printWinner(winners: Winners) {
        println(
            "$HEADER_WINNERS " + "${winners.winners.joinToString(",") { it.name }} ",
        )
    }
}
