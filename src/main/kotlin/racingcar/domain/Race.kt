package racingcar.domain

import racingcar.utils.Constants.COMMA
import racingcar.utils.Constants.MOVE_MAX_RANGE
import racingcar.utils.Constants.MOVE_MIN_RANGE

class Race(rawCarNames: String, rawTryCount: String) {
    val tryCount = rawTryCount.toInt()
    val cars = getCars(rawCarNames)

    private fun getCars(rawCarNames: String): List<Car> {
        return rawCarNames.split(COMMA).map { Car(it.trim()) }
    }

    private fun isMove(randomNumber: Int): Boolean {
        return randomNumber in MOVE_MIN_RANGE..MOVE_MAX_RANGE
    }

    fun getPositions() {
        val generateRandomNumber = GenerateRandomNumber()
        repeat(tryCount) {
            cars.forEach { car ->
                val randomNumber = generateRandomNumber.randomNumber()
                car.moves(isMove(randomNumber))
            }
        }
    }

    fun getWinners(): List<String> {
        val maxNumber = cars.maxOfOrNull { it.moveCount() }
        val winners =
            cars.filter { car ->
                car.moveCount() == maxNumber
            }.map { it.carName }
        return winners
    }
}
