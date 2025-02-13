package racingcar

import racingcar.domain.Car
import racingcar.domain.Configure.Companion.RANDOM_SEED
import racingcar.domain.Messages
import kotlin.random.Random

fun main() {
    Application().run()
}

class Application(
    private val cars: List<Car> = InputInitializer.getCars(),
    private val raceCount: Int = InputInitializer.getRaceCount(),
) {
    private val random = Random(RANDOM_SEED)

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
        println(Messages.WINNER.formattedMessage(winners.joinToString(", ") { it.name }))
    }

    private fun race() {
        cars.forEach {
            if (random.nextInt(0, 10) >= 4) it.randomMove()
            it.printDistanceInfo()
        }
    }
}
