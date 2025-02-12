package racingcar

import racingcar.domain.Car
import racingcar.domain.Messages

fun main() {
    Application().run()
}

class Application(
    private val cars:List<Car> = InputInitializer.getCars(),
    private val raceCount:Int = InputInitializer.getRaceCount()
) {

    fun run() {
        startGame()
        getWinner()
    }

    private fun startGame() {
        println(Messages.GAME_RESULT.message)
        repeat(raceCount) {
            race()
            println()
        }
    }

    private fun getWinner() {
        val winners = cars.filter { it.distance == cars.maxOf { car -> car.distance } }
        println(Messages.WINNER.formattedMessage(winners.joinToString(", ") {it.name}))
    }

    private fun race() {
        cars.forEach {
            it.randomMove()
            it.printDistanceInfo()
        }
    }
}
