package racingcar.service

import racingcar.domain.Car

private const val START_RANDOM_NUMBER = 0
private const val END_RANDOM_NUMBER = 9

class RacingService(private val cars: List<Car>) {
    fun raceRound() {
        cars.forEach { car -> car.proceed((START_RANDOM_NUMBER..END_RANDOM_NUMBER).random()) }
    }

    fun findWinners(): List<Car> {
        return cars
            .filter { car -> car.position == findMaxPosition() }
            .toList()
    }

    private fun findMaxPosition(): Int {
        return cars
            .maxOf { car -> car.position }
    }

    fun getCars(): List<Car> {
        return cars
    }
}