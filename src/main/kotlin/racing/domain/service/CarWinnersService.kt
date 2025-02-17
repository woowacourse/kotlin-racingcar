package racing.domain.service

import racing.domain.model.Car

class CarWinnersService(private val cars: List<Car>) {
    fun getWinners(): List<Car> {
        val topPositionCar = cars.maxOf { it }
        return cars.filter { car -> car.position == topPositionCar.position }
    }
}
