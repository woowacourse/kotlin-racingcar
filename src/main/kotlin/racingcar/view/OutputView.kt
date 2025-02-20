package racingcar.view

import racingcar.model.Car

class OutputView {
    fun printRound(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${INDICATOR_CAR_POSITION.repeat(car.position)}")
        }
    }

    fun printResultHeader() {
        println(MESSAGE_OUTPUT_RACE_RESULT)
    }

    fun printWinner(winner: List<String>) {
        println(MESSAGE_OUTPUT_WINNER + winner.joinToString(DELIMITER_WINNER_OUTPUT))
    }

    companion object {
        private const val MESSAGE_OUTPUT_RACE_RESULT = "\n실행 결과"
        private const val MESSAGE_OUTPUT_WINNER = "최종 우승자: "

        const val INDICATOR_CAR_POSITION = "-"
        const val DELIMITER_WINNER_OUTPUT = ", "
    }
}
