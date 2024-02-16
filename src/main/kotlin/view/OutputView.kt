package view

import model.Car

class OutputView {

    fun printResultComment() {
        println(RESULT_COMMENT)
    }

    fun printRoundResult(cars: List<Car>) {
        cars.forEach { printCarResult(it) }.also { println() }
    }

    fun printWinners(winners: List<String>) {
        println(getWinnersComment(winners))
    }

    private fun printCarResult(car: Car) {
        println(getRoundResult(car))
    }

    companion object {
        private const val RESULT_COMMENT = "\n실행결과"
        private fun getWinnersComment(winners: List<String>) = "최종 우승자: ${winners.joinToString()}"
        private fun getRoundResult(car: Car) = "${car.name} : ${"-".repeat(car.getForwardCount())}"
    }
}
