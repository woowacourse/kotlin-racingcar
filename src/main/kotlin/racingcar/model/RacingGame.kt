package racingcar.model

import racingcar.util.Constant

class RacingGame(
    private val cars: List<Car>
) {

    fun racingCars(randomNumbers: List<Int>) {
        cars.forEachIndexed { index, car ->
            if (judgeMoveStop(randomNumbers[index])) {
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

    private fun judgeMoveStop(randomNumber: Int): Boolean {
        return randomNumber >= Constant.STANDARD_RANDOM_NUMBER
    }
}
