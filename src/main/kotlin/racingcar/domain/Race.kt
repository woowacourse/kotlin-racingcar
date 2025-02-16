package racingcar.domain

import racingcar.utils.Constants.COMMA

class Race(carNames: String, tryCount: String) {
    val tryCount = tryCount.toInt()
    val cars = carNames.split(COMMA).map { Car(it) }
    private val generateRandomNumber = GenerateRandomNumber()

    fun runRound() {
        cars.forEach { car ->
            val randomNumber = generateRandomNumber.randomNumber()
            car.moveOrStop(randomNumber)
        }
    }

    fun getWinners(): List<String> {
        val maxPosition = cars.maxOfOrNull { it.getPosition() }
        return cars.filter { it.getPosition() == maxPosition }.map { it.getName() }
    }
}
