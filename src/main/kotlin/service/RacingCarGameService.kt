package service

import model.Car

class RacingCarGameService {

    fun splitCarNames(carNames: String): List<String> = carNames.split(",")

    fun initCarsInfo(carNames: List<String>): List<Car> {
        val carsInfo = mutableListOf<Car>()
        carNames.forEach { name ->
            carsInfo.add(Car(name, DEFAULT_CAR_POSITION))
        }

        return carsInfo.toList()
    }

    fun moveCars(carsInfo: List<Car>): List<Car> {
        carsInfo.forEach { car ->
            car.moveForward(car.isPossibleMove(RandomNumberGenerator().generate()))
        }

        return carsInfo
    }

    fun getMaxPositionCars(carsInfo: List<Car>): List<Car> {
        val maxCarInfo = carsInfo.maxWith(Car::compareTo)
        return carsInfo.filter { maxCarInfo.isSamePosition(it) }
    }

    companion object {
        private const val DEFAULT_CAR_POSITION = 0
    }
}
