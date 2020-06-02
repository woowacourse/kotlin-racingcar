package racing.domain

class Cars(quantity: Int) {
    private val cars = (1..quantity).map { Car() }

    fun race() = cars.forEach { it.move() }
    fun status(): List<Position> = cars.map { it.position }
}
