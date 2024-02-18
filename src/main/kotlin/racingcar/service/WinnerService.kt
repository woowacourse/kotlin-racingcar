package racingcar.service

import racingcar.domain.Car

object WinnerService {
    fun findWinners(cars: List<Car>): List<String> {
        val maxPosition = cars.maxOfOrNull { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }
}
