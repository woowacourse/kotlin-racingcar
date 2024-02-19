package view

import domain.Cars

class OutputView {
    fun printResultHeader() = println(HEADER_RESULT)

    fun printPhase(cars: Cars) {
        cars.cars.forEach {
            println("${it.name} :" + MOVEMENT_INDICATOR.repeat(it.position))
        }
        println()
    }

    fun printWinner(cars: Cars) {
        val maxPosition =
            cars.cars.maxOf {
                it.position
            }

        val winners =
            cars.cars.filter {
                it.position == maxPosition
            }

        println(
            "$HEADER_WINNERS " +
                "${winners.joinToString(",") { it.name }} ",
        )
    }

    fun showExceptionMessage(e: Throwable) = println(e.message)

    companion object {
        private const val MOVEMENT_INDICATOR = "-"
        private const val HEADER_RESULT = "실행 결과"
        private const val HEADER_WINNERS = "최종 우승자 :"
    }
}
