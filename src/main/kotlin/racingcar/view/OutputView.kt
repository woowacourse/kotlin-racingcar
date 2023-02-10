package racingcar.view

import racingcar.constant.INPUT_CARS_NAME
import racingcar.constant.INPUT_ROUND_COUNT
import racingcar.constant.OUTPUT_RESULT
import racingcar.constant.OUTPUT_WINNER
import racingcar.constant.STATE_UNIT
import racingcar.domain.RacingCar

class OutputView {
    fun printGettingCarsName() {
        println(INPUT_CARS_NAME)
    }

    fun printGettingRoundCount() {
        println(INPUT_ROUND_COUNT)
    }

    fun printResult() {
        println(OUTPUT_RESULT)
    }

    fun printEachRound(cars: List<RacingCar>) {
        cars.forEach { car ->
            "${car.name} : ${STATE_UNIT.repeat(car.movingState)}"
        }
        println()
    }

    fun printWinner(winner: List<String>) {
        println("$OUTPUT_WINNER${winner.joinToString(separator = ", ")}")
    }
}
