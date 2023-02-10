package domain

class Judgement(private val cars: List<Car>) {

    fun findWinners(): List<String> {
        val maxDistance = cars.maxOf { it.getDistance() }
        return cars.filter { car -> car.getDistance() == maxDistance }.map { it.name }
    }
}
