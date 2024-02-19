package racingcar.view

import racingcar.domain.Car

object OutputView {
    fun printResultMessage() {
        println("\n실행 결과")
    }

    fun printRoundResult(cars: List<Car>) {
        cars.forEach {
            println("${it.name} : ${"-".repeat(it.position)}")
        }
        println()
    }

    fun printWinners(winners: List<String>) {
        println("최종 우승자: ${winners.joinToString(", ")}")
    }

    fun printErrorMessage(e: String) {
        println(e)
    }

}
