package domain

object Referee {

    fun judgeWinner(cars: List<Car>): List<String> {
        val winnersContainer = mutableListOf<String>()

        val maxDistance = cars.maxOf { it.distance.length }
        findWinners(winnersContainer, maxDistance, cars)

        return winnersContainer
    }

    private fun findWinners(winnersContainer: MutableList<String>, maxDistance: Int, cars: List<Car>) {
        cars.forEach {
            compareDistanceWithMax(winnersContainer, maxDistance, it)
        }
    }

    private fun compareDistanceWithMax(winnersContainer: MutableList<String>, maxDistance: Int, car: Car) {
        if (car.distance.length == maxDistance) winnersContainer.add(car.carName)
    }
}
