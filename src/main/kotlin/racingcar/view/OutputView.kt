package racingcar.view

import racingcar.domain.Car
import racingcar.utils.Constants.COMMA
import racingcar.utils.Constants.MOVE
import racingcar.utils.Constants.WINNERS_MESSAGE

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
}
