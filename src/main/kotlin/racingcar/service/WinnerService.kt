package racingcar.service

import racingcar.model.Car

class WinnerService {
    fun getWinners(cars: List<Car>): List<Car> {
        val maxPosition = cars.maxOfOrNull { it.position } ?: return emptyList()
        return cars.filter { it.position == maxPosition }
    }
}
