package view

import model.Car
import model.Cars
import util.Constants
import util.Messages

object OutputView {
    fun printRound(car: Car) {
        println("${car.name} : ${Constants.INDICATOR_CAR_POSITION.repeat(car.position)}")
    }

    fun printResultHeader() {
        println(Messages.MESSAGE_OUTPUT_RACE_RESULT)
    }

    fun printWinner(winners: Cars) {
        println(Messages.MESSAGE_OUTPUT_WINNER + winners.cars.joinToString(Constants.DELIMITER_WINNER_OUTPUT) { it.name })
    }
}
