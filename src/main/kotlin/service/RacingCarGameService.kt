package service

import model.Car

class RacingCarGameService {

    fun splitCarNames(carNames: String): List<String> = carNames.split(",")

    fun initCarInfo(carNames: List<String>): List<Car> {
        val carsInfo = mutableListOf<Car>()
        carNames.forEach { name ->
            carsInfo.add(Car(name, 0))
        }

        return carsInfo.toList()
    }

    fun moveCars(carsInfo: List<Car>): List<Car> {
        carsInfo.forEach { car ->
            car.moveForward(car.isPossibleMove(RandomNumberGenerator().generate()))
        }

        return carsInfo
    }

    fun getWinnersInfo(carsInfo: List<Car>): List<Car> {
        val maxCarInfo = carsInfo.maxWith(Car::compareTo)
        return carsInfo.filter { maxCarInfo.isSamePosition(it) }
    }

    fun getRoundResult(carsInfo: List<Car>): String {
        var roundResult = ""
        carsInfo.forEach { car ->
            roundResult += "${car.getPresentStatus()}\n"
        }
        return roundResult
    }

    fun getWinnerNames(carsInfo: List<Car>): List<String> {
        var winnerNames = mutableListOf<String>()

        carsInfo.forEach { car ->
            winnerNames.add(car.name)
        }
        return winnerNames
    }
}
