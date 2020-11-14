package racingcar.domain

import kotlin.streams.toList

class Cars(private val cars: List<Car>) {
    val size: Int
        get() = cars.size

    val winner: List<Car>
        get() = run {
            val winner = cars.maxByOrNull(Car::position) ?: throw AssertionError()
            return cars.stream()
                .filter { it.position == winner.position }
                .toList()
        }

    fun go(): List<RacingHistory> {
        cars.forEach { it.go(RandomPower.generate()) }
        return cars.map { RacingHistory(it.name, it.position) }
    }
}