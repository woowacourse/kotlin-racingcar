package racingcar

import racingcar.domain.Car
import racingcar.domain.GameResult
import racingcar.global.InputValidator.requireCarNames
import racingcar.global.InputValidator.requireRaceCount
import racingcar.global.Messages

class View {
    fun getRaceCount(): Int {
        println(Messages.GAME_INPUT_COUNT.message)
        return requireRaceCount(readln()).toInt()
    }

    fun getCars(): List<Car> {
        println(Messages.GAME_START.message)
        val input = requireCarNames(readln())
        return input.split(",").map { Car(it.trim()) }
    }

    fun printResult(gameResult: GameResult) {
        println(Messages.GAME_RESULT.message)
        println(gameResult.toString())
    }

    fun printWinner(winners: List<Car>) {
        println(Messages.WINNER.formattedMessage(winners.joinToString(", ") { it.name }))
    }
}
