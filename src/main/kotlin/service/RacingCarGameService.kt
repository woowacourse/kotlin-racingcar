package service

import model.Car

class RacingCarGameService {
    fun isPossibleMove(): Boolean = RandomNumberGenerator().generate() >= 4

    fun splitCarNames(carNames: String): List<String> = carNames.split(",")

    fun initCarInfo(carNames: List<String>): List<Car> {
        val carsInfo = mutableListOf<Car>()
        carNames.forEach { name ->
            carsInfo.add(Car(name, 0))
        }

        return carsInfo.toList()
    }

    fun getRoundResult(carsInfo: List<Car>): List<Car> {
        carsInfo.forEach { car ->
            car.position += moveForward(isPossibleMove())
        }

        return carsInfo
    }

    fun moveForward(isPossibleMove: Boolean): Int = if (isPossibleMove) 1 else 0
}
