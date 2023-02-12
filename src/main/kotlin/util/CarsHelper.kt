package util

import model.Cars

object CarsHelper {
    fun findWinners(cars: Cars): List<String> {
        val carInfos = cars.getCarInfos()
        val equalCars = carInfos.groupBy({ it.position }, { it.name })
        return equalCars[equalCars.keys.max()]?.toList() ?: listOf()
    }
}
