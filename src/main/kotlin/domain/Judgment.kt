package domain

class Judgment {
    fun findWinners(cars: List<Car>): List<String> {
        val maxCount = cars.maxOfOrNull { car ->
            car.moveCount
        }
        return cars.filter { car ->
            car.moveCount == maxCount
        }.map { winner ->
            winner.name
        }
    }
}