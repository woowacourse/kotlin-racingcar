package racingcar.model

import racingcar.util.Constant

class RacingGame(
    private val cars: List<Car>
) {

    fun racingCars(randomNumbers: List<Int>) {
        cars.forEachIndexed { index, car ->
            racingCar(
                randomNumber = randomNumbers[index],
                car = car
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

    private fun judgeMoveStop(randomNumber: Int): Boolean {
        return randomNumber >= Constant.STANDARD_RANDOM_NUMBER
    }

    private fun racingCar(
        randomNumber: Int,
        car: Car
    ) {
        if (judgeMoveStop(randomNumber)) {
            car.moveCar()
        }
    }
}
