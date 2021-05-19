package racingcar.domain.car

import java.util.*
import kotlin.streams.toList

const val RANDOM_BOUND_TO = 10

class Cars(cars: List<Car>) {
    private val random = Random()
    private val cars: List<Car>

    init {
        validateDistinct(cars)
        this.cars = cars
    }

    fun moveCars() {
        cars.stream()
            .forEach { it.tryToMove(random.nextInt(RANDOM_BOUND_TO)) }
    }

    fun findWinners(): Cars {
        val maxPosition = findMaxPosition()
        return Cars(cars.stream()
            .filter { it.isIn(maxPosition) }
            .toList())
    }

    private fun findMaxPosition(): Int {
        return cars.stream()
            .mapToInt { it.position() }
            .max()
            .orElseGet { 0 }
    }

    fun cars(): List<Car> {
        return cars
    }

    private fun validateDistinct(cars: List<Car>) {
        val distinctSize = cars.stream()
            .map { it.name() }
            .distinct()
            .count()
            .toInt()

        if (cars.size != distinctSize) {
            throw IllegalArgumentException("중복된 이름을 사용할 수 없습니다.")
        }
    }
}

