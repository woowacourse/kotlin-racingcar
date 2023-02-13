package domain

class Judgment {
    fun findWinners(cars: List<Car>): List<String> {
        return findWinnersBy(cars, getMaxCount(cars))
    }

    private fun getMaxCount(cars: List<Car>): Int {
        return cars.maxOf { car ->
            car.moveCount
        }
    }

    private fun findWinnersBy(cars: List<Car>, maxCount: Int): List<String> {
        return cars.filter { car ->
            car.moveCount == maxCount
        }.map { winner ->
            winner.name
        }
    }
}