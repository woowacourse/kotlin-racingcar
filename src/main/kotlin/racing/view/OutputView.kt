package racing.view

import racing.model.Car

object OutputView {

    fun printCurrentPosition(cars: List<Car>) {
        for (car in cars) {
            println("${car.name} : ${getDash(car.position)}")
        }
        println()
    }

    private fun getDash(position: Int): String {
        val result = StringBuilder()
        repeat(position) {
            result.append("-")
        }
        return result.toString()
    }

    fun printWinners(winners: List<String>) {
        println("최종 우승자: ${winners.joinToString(", ")}")
    }
}
