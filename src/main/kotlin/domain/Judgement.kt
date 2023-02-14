package domain

class Judgement(private val cars: List<Car>) {

    fun findWinners(): List<String> {
        val maxDistance = cars.maxOf { it.distance }
        return cars.filter { car -> car.distance == maxDistance }.map { it.name }
    }
}
