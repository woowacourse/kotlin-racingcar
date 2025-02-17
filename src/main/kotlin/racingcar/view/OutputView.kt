package racingcar.view

import racingcar.domain.Car
import racingcar.utils.Constants.COMMA

class OutputView {
    fun printRoundResult(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.getName()} : ${MOVE.repeat(car.getPosition())}")
        }
        println()
    }

    fun printWinners(winners: List<String>) {
        println("$WINNERS_MESSAGE ${winners.joinToString("$COMMA ")}")
    }

    companion object {
        private const val MOVE = "-"
        private const val WINNERS_MESSAGE = "최종 우승자:"
    }
}
