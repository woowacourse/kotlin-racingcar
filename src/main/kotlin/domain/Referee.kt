package domain

object Referee {

    fun judgeWinner(cars: List<Car>): List<String> {
        val maxDistance = cars.maxOf { it.distance.length }

        return findWinners(maxDistance, cars)
    }

    private fun findWinners(maxDistance: Int, cars: List<Car>) =
        cars.filter { it.distance.length == maxDistance }.map { it.carName }


}
