package racingcar.service

import racingcar.model.Car

class WinnerService {
    fun getWinners(cars: List<Car>): List<Car> {
        val maxCarPosition = cars.sorted()[0]
        return cars.filter { it.compareTo(maxCarPosition) == 0 }
    }
}
