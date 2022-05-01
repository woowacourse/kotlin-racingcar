package racingcar.service

import racingcar.domain.Car
import racingcar.domain.Cars

class RacingService(private val cars: Cars) {
    fun raceRound() {
        cars.proceed()
    }

    fun findWinners(): List<Car> {
        return cars.findWinners()
    }

    fun getCars(): List<Car> {
        return cars.getCars()
    }
}