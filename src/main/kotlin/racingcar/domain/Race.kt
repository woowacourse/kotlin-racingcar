package racingcar.domain

import racingcar.utils.Constants.COMMA
import racingcar.utils.Constants.MOVE_MAX_RANGE
import racingcar.utils.Constants.MOVE_MIN_RANGE

class Race(rawCarNames: String, rawTryCount: String) {
    val tryCount = rawTryCount.toInt()
    val cars = rawCarNames.split(COMMA).map { Car(it) }

    private fun isMove(randomNumber: Int): Boolean {
        return randomNumber in MOVE_MIN_RANGE..MOVE_MAX_RANGE
    }

    fun runRound() {
        val generateRandomNumber = GenerateRandomNumber()
        cars.forEach { car ->
            val randomNumber = generateRandomNumber.randomNumber()
            car.moveOrStop(isMove(randomNumber))
        }
    }

    fun getWinners(): List<String> {
        val maxPosition = cars.maxOfOrNull { it.getPosition() }
        return cars.filter { it.getPosition() == maxPosition }.map { it.getName() }
    }
}
