package racingcar.model

import racingcar.util.Constant
import kotlin.random.Random

class RacingGame(
    private val cars: List<Car>
) {
    fun racingCars() {
        cars.forEach { car ->
            racingCar(car = car)
        }
    }

    fun judgeWinners(): List<String> {
        val maxPosition = findMaxPosition()
        return cars.filter { car ->
            car.position == maxPosition
        }.map { car ->
            car.name
        }
    }

    private fun racingCar(
        car: Car
    ) {
        val randomNumber = generateRandomNumber()
        if (judgeMoveStop(randomNumber = randomNumber)) {
            car.moveCar()
        }
    }

    private fun judgeMoveStop(randomNumber: Int): Boolean {
        return randomNumber >= Constant.STANDARD_RANDOM_NUMBER
    }

    private fun generateRandomNumber(): Int {
        return Random.nextInt(Constant.MAX_RANDOM_NUMBER)
    }

    private fun findMaxPosition(): Int {
        return cars.maxOf { car ->
            car.position
        }
    }
}
