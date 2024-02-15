package view

import model.Car

class OutputView {

    fun printResultComment() {
        println("\n실행결과")
    }

    fun printRoundResult(cars: List<Car>) {
        cars.forEach { printCarResult(it) }
    }

    fun printWinners(winners: List<String>) {
        println("최종 우승자: ${winners.joinToString()}")
    }

    private fun printCarResult(car: Car) {
        println("${car.name} : ${"-".repeat(car.getForwardCount())}")
    }
}