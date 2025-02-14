package racingcar

import racingcar.domain.Car
import racingcar.domain.Configure.Companion.RANDOM_SEED
import racingcar.domain.Messages
import kotlin.random.Random

class RaceService {
    private val random = Random(RANDOM_SEED)
    private var stringBuilder = StringBuilder()

    fun getWinner(cars: List<Car>): String {
        val winners = cars.filter { it.distance == cars.maxOf { car -> car.distance } }
        return Messages.WINNER.formattedMessage(winners.joinToString(", ") { it.name })
    }

    fun race(
        raceCount: Int,
        cars: List<Car>,
    ): String {
        repeat(raceCount) {
            singleRace(cars)
            stringBuilder.append("\n")
        }
        return stringBuilder.toString()
    }

    private fun singleRace(cars: List<Car>) {
        cars.forEach {
            it.moveByValue(random.nextInt(0, 10))
            stringBuilder.append(it.getDistanceInfo() + "\n")
        }
    }
}
