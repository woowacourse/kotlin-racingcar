package view

import model.Car
import model.Game
import util.Constants
import util.Messages

object OutputView {
    fun printState(game: Game) {
        game.cars.forEach { car ->
            println("${car.name} : ${Constants.INDICATOR_CAR_POSITION.repeat(car.position)}")
        }
        println()
    }

    fun printResultHeader() {
        println(Messages.MESSAGE_OUTPUT_RACE_RESULT)
    }

    fun printWinner(winners: List<Car>) {
        println(Messages.MESSAGE_OUTPUT_WINNER + winners.joinToString(Constants.DELIMITER_WINNER_OUTPUT) { it.name })
    }
}
