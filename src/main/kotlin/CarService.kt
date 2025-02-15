class CarService(private val _cars: List<Car>) {
    val cars get() = _cars.map { car -> car.copy() }

    fun race() = _cars.forEach { car -> car.move(TryMoveNumberGenerator()) }

    fun getWinners(): List<Car> {
        val maxPosition = cars.maxOf { car -> car.position }
        return cars.filter { car -> car.position == maxPosition }
    }
}
