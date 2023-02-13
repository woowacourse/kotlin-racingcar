package domain

import common.ERROR_MESSAGE_FORMAT

class GameCars(val cars: Set<Car>) {

    init {
        require(cars.size in 2..20) {
            ERROR_MESSAGE_FORMAT.format(CARS_SIZE_ERROR).plus("\n${ILLEGAL_INPUT_CARS_SIZE_FORMAT.format(cars.size)}")
        }
    }

    fun advanceAllCars() = cars.forEach { it.moveAccordingToStrategy() }

    fun getMostAdvancedCars(): List<Car> {
        val maxAdvancedCount: Int = cars.maxOf { it.advancedCount }
        return cars.filter { it.advancedCount == maxAdvancedCount }
    }
}

private const val CARS_SIZE_ERROR = "자동차는 최소 2대에서 최대 20대 사이여야 합니다."
private const val ILLEGAL_INPUT_CARS_SIZE_FORMAT = "입력된 자동차 개수: %s"
