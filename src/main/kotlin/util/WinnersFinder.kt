package util

import model.Cars

object WinnersFinder {
    fun findWinners(cars: Cars): List<String> {
        val equalCars = cars.cars.groupBy({ it.position }, { it.name })
        return equalCars[equalCars.keys.max()]?.toList() ?: emptyList()
    }
}
