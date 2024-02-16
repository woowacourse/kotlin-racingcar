package racingcar.service

import racingcar.model.Car

class WinnerService {
    fun getWinners(cars: List<Car>): List<Car> {
        val maxForwardCountCar = cars.maxOf { it.forwardCount }
        return cars.filter { car ->
            car.forwardCount == maxForwardCountCar
        }
    }
}
