package view

import model.Car
import model.Game

object OutputView {
    fun printState(game: Game) {
        game.cars.forEach { car ->
            println("${car.name} : ${CAR_POSITION_INDICATOR.repeat(car.position)}")
        }
        println()
    }

    fun printResultHeader() {
        println()
        println(MESSAGE_OUTPUT_RESULT_HEADER)
    }

    fun printWinner(winners: List<Car>) {
        println(MESSAGE_OUTPUT_WINNER_PREFIX + winners.joinToString(WINNER_OUTPUT_SEPARATOR) { it.name })
    }

    fun printMessage(prompt: String) {
        println(prompt)
    }

    private const val CAR_POSITION_INDICATOR = "-"
    private const val WINNER_OUTPUT_SEPARATOR = ", "

    private const val MESSAGE_OUTPUT_RESULT_HEADER = "실행 결과"
    private const val MESSAGE_OUTPUT_WINNER_PREFIX = "최종 우승자: "
}
