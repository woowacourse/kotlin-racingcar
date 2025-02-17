package racing.ui.view

import racing.domain.model.Car

class OutputView {
    fun printRemoveDuplicateCars() {
        println(CAR_DUPLICATE_REMOVE)
    }

    fun printResultTitle() = println(RESULT)

    fun printCarState(cars: List<Car>) {
        cars.forEach { car -> println("${car.name}$CAR_STATE_DELIMITER${CAR_POSITION.repeat(car.position)}") }
        println()
    }

    fun printRaceWinner(winners: List<Car>) = println("$FINAL_WINNER ${winners.joinToString(WINNER_DELIMITER) { winner -> winner.name }}")

    companion object {
        private const val RESULT = "실행결과"
        private const val FINAL_WINNER = "최종 우승자:"
        private const val CAR_POSITION = "-"
        private const val WINNER_DELIMITER = ", "
        private const val CAR_STATE_DELIMITER = " : "
        private const val CAR_DUPLICATE_REMOVE = "중복된 자동차를 제거하였습니다."
    }
}
