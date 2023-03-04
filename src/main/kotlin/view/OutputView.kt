package view

import domain.Car
import domain.Cars

private const val COLON = " : "
private const val DASH = "-"

object OutputView {

    fun printException(e: Exception) {
        println(e.message)
        println()
    }

    fun printResultTitle() {
        println("실행 결과")
    }

    fun printRaceResult(cars: Cars) {
        cars.value.forEach {
            println(it.name + COLON + DASH.repeat(it.position))
        }
        println()
    }

    fun printWinner(winners: List<Car>) {
        println("${winners.joinToString(separator = ", ") { it.name }}가 최종 우승했습니다.")
    }
}