package racingcar.view

import racingcar.model.Car
import racingcar.util.Constants
import racingcar.util.Messages

object OutputView {
    fun printRound(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${Constants.INDICATOR_CAR_POSITION.repeat(car.position)}")
        }
    }

    fun printResultHeader() {
        println(Messages.MESSAGE_OUTPUT_RACE_RESULT)
    }

    fun printWinner(winner: List<String>) {
        println(Messages.MESSAGE_OUTPUT_WINNER + winner.joinToString(Constants.DELIMITER_WINNER_OUTPUT))
    }
}
