package model

import java.lang.IllegalArgumentException

class Game(val cars: List<Car>, val rounds: Int) {
    init {
        require(cars.size == cars.toSet().size) { throw IllegalArgumentException(MESSAGE_DUPLICATE_CAR_NAME) }
        require(cars.size > 1) { throw IllegalArgumentException(MESSAGE_NOT_ENOUGH_CARS) }
        require(rounds > 1) { throw IllegalArgumentException(MESSAGE_ROUNDS_TOO_SMALL) }
    }

    fun moveCars() {
        cars.forEach { car ->
            val randomNumber = (RANDOM_NUMBER_MIN..RANDOM_NUMBER_MAX).random()
            car.move(randomNumber)
        }
    }

    fun getWinner(): List<Car> {
        val max = cars.maxOf { it.position }
        val winner = cars.filter { it.position == max }
        return winner
    }

    companion object {
        const val RANDOM_NUMBER_MIN = 0
        const val RANDOM_NUMBER_MAX = 9

        private const val MESSAGE_DUPLICATE_CAR_NAME = "자동차 이름에 중복이 있습니다."
        private const val MESSAGE_NOT_ENOUGH_CARS = "최소 두 대의 자동차가 참가해야 합니다."
        private const val MESSAGE_ROUNDS_TOO_SMALL = "경주 횟수는 1 이상이어야 합니다."
    }
}
