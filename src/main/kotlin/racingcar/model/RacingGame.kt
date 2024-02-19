package racingcar.model

import racingcar.MoveStrategy
import racingcar.util.Constant
import kotlin.random.Random

class RacingGame(
    private val cars: List<Car>
) : MoveStrategy {
    fun racingCars(randomBound: Pair<Int, Int>) {
        cars.forEach { car ->
            racingCar(
                car = car,
                randomBound = randomBound
            )
        }
    }

    fun judgeWinners(): List<Car> {
        val maxPosition = findMaxPosition()
        return cars.filter { car ->
            car.position == maxPosition
        }
    }

    private fun racingCar(
        car: Car,
        randomBound: Pair<Int, Int>
    ) {
        if (shouldMove(randomBound = randomBound)
        ) {
            car.moveCar()
        }
    }

    private fun findMaxPosition(): Int {
        return cars.maxOf { car ->
            car.position
        }
    }

    override fun shouldMove(randomBound: Pair<Int, Int>): Boolean {
        val minRandomNumber = randomBound.first
        val maxRandomNumber = randomBound.second
        return Random.nextInt(minRandomNumber, maxRandomNumber) >= Constant.STANDARD_RANDOM_NUMBER
    }
}
