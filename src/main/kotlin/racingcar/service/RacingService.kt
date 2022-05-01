package racingcar.service

import racingcar.domain.Car
import racingcar.ui.printRoundResult
import racingcar.utils.random

private const val START_RANDOM_NUMBER = 0
private const val END_RANDOM_NUMBER = 9

class KRacingService(private val cars: List<Car>) {

    fun race(round: Int) {
        for (i: Int in START_RANDOM_NUMBER..round) {
            raceRound()
        }
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

    private fun raceRound() {
        cars.forEach { car -> car.proceed(random(START_RANDOM_NUMBER, END_RANDOM_NUMBER)) }
        printRoundResult(cars)
    }
}