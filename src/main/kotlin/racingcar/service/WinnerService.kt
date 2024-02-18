package racingcar.service

import racingcar.model.Car

object WinnerService {
    fun getWinners(cars: List<Car>): List<Car> {
        val maxForwardCountCar = cars.maxOf { it.position }
        return cars.filter { car ->
            car.position == maxForwardCountCar
        }
    }
}
