package racingcar.domain.model

import racingcar.data.RandomNumberMaker
import racingcar.util.Constant
import kotlin.random.Random

class RacingGame(
    private val cars: List<Car>
) : RandomNumberMaker {

    fun racingCars(
        minNumber: Int,
        maxNumber: Int
    ) {
        cars.forEach { car ->
            val randomNumber = makeRandomNumber(
                minNumber = minNumber,
                maxNumber = maxNumber
            )
            racingCar(
                car = car,
                randomNumber = randomNumber
            )
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

    private fun racingCar(
        car: Car,
        randomNumber: Int
    ) {
        if (judgeMoveStop(randomNumber)) {
            car.moveCar()
        }
    }

    private fun judgeMoveStop(randomNumber: Int): Boolean {
        return randomNumber >= Constant.STANDARD_RANDOM_NUMBER
    }

    override fun makeRandomNumber(minNumber: Int, maxNumber: Int): Int {
        return Random.nextInt(
            from = minNumber,
            until = maxNumber
        )
    }
}
