package controller

import domain.Car
import domain.Cars

class Winner(private val cars: Cars) {

    fun findWinnerNames(): List<Car> {
        val maxScore: Int = cars.cars.maxBy { it.distance }?.distance ?: 0
        return cars.cars.filter { car -> car.distance == maxScore }
    }
}
