package view

import domain.Car

class OutputView {

    fun printRoundResultHeader() {
        println()
        println("실행 결과")
    }

    fun printRoundResult(cars: List<Car>) {
        val stringBuilder = StringBuilder()

        cars.forEach { car ->
            stringBuilder
                .append(car.name.value)
                .append(" : ")
                .append("-".repeat(car.position.value))
                .append(System.lineSeparator())
        }

        println(stringBuilder)
    }

    fun printGameResult(winners: List<Car>) {
        val winnerNames = winners.map { winner -> winner.name.value }

        println("최종 우승자: " + winnerNames.joinToString(", "))
    }

    fun printErrorMessage(errorMessage: String) {
        println(errorMessage)
        println()
    }
}
