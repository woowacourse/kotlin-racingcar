package racingcar.model

import racingcar.util.Constant
import kotlin.random.Random

class RacingGame(
    private val cars: List<Car>
) {

    fun racingCars() {
        cars.forEach { car ->
            if (judgeMoveStop(makeRandomNumber())) {
                car.moveCar()
            }
        }
    }

    fun judgeWinners(): List<Car> {
        val maxStep = findMaxStep()
        return cars.filter { car ->
            car.getStep() == maxStep
        }
    }

    private fun findMaxStep(): Int {
        return cars.maxOf { car ->
            car.getStep()
        }
    }

    private fun makeRandomNumber(): Int {
        return Random.nextInt(Constant.MIN_RANDOM_NUMBER, Constant.MAX_RANDOM_NUMBER)
    }

    private fun judgeMoveStop(randomNumber: Int): Boolean {
        return randomNumber >= Constant.STANDARD_RANDOM_NUMBER
    }
}
