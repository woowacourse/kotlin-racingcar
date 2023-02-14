package domain

object Referee {
    fun judgeWinners(cars: List<Car>): List<String> {
        val maxMoveCount = findMaxMoveCount(cars)
        return findWinnersBy(cars, maxMoveCount)
    }

    private fun findMaxMoveCount(cars: List<Car>) = cars.maxOf { it.moveCount }

    private fun findWinnersBy(cars: List<Car>, maxCount: Int): List<String> {
        return cars.filter { car ->
            car.moveCount == maxCount
        }.map { winner ->
            winner.name
        }
    }
}
