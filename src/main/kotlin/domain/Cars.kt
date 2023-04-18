package domain

class Cars(val cars: List<Car>) {

    fun findWinners(): List<Car> {
        val maxPosition = findMaxPosition()
        return cars.filter { it.isSamePosition(maxPosition) }

    }

    private fun findMaxPosition(): Int {
        return cars.maxOf { it.position.value }
    }

    fun moveCars(numberGenerator: NumberGenerator) {
        cars.forEach { car -> car.move(numberGenerator) }
    }
}
