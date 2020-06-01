package domain

class Cars(cars: List<Car> = emptyList()) {
    private val cars: List<Car> = listOf(*cars.toTypedArray())

    fun move() {
        for (car in cars) {
            car.move()
        }
    }

    fun values(): List<Car> = cars
}
