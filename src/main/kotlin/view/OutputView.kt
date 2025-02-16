package view

import model.car.Car

class OutputView {
    fun printDuplicate() {
        println(CAR_DUPLICATE_REMOVE)
    }

    fun printResultTitle() = println(RESULT)

    fun printCarState(cars: List<Car>) {
        cars.forEach { car -> println("${car.name}$CAR_STATE_DELIMITER${CAR_POSITION.repeat(car.position)}") }
        println()
    }

    fun printRaceWinner(winners: List<Car>) = println("$FINAL_WINNER ${winners.joinToString(WINNER_DELIMITER) { winner -> winner.name }}")

    companion object {
        const val RESULT = "실행결과\n"
        const val CAR_POSITION = "-"
        const val FINAL_WINNER = "최종 우승자:"
        const val WINNER_DELIMITER = ", "
        const val CAR_DUPLICATE_REMOVE = "중복된 차이름을 제거하였습니다."
        const val CAR_STATE_DELIMITER = " : "
    }
}
