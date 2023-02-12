package domain

import common.ERROR_MESSAGE_FORMAT

class GameCars(val cars: List<Car>) {

    init {
        require(cars.isNotDuplicated()) { ERROR_MESSAGE_FORMAT.format(CAR_DISTINCT_ERROR) }
        require(cars.size in 2..20) { ERROR_MESSAGE_FORMAT.format(CARS_SIZE_ERROR) }
    }

    fun advanceAllCars() = cars.forEach { it.moveAccordingToStrategy() }

    fun getMostAdvancedCars(): List<Car> {
        val maxAdvancedCount: Int = cars.maxOf { it.advanceCount }
        return cars.filter { it.advanceCount == maxAdvancedCount }
    }
}

private fun List<Car>.isNotDuplicated(): Boolean = this.size == this.distinct().size

private const val CAR_DISTINCT_ERROR = "자동차 이름 간에 중복이 존재합니다."
private const val CARS_SIZE_ERROR = "자동차는 최소 2대에서 최대 20대 사이여야 합니다."
private const val ADVANCE_COUNT_ERROR = "한 게임 동안 전진 횟수는 최소 1회에서 최대 100회 사이여야 합니다."
