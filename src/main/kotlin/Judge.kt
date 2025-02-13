class Judge {
    fun selectWinners(cars: List<Car>): List<String> {
        val maxPosition = cars.maxOf { car -> car.position }
        return cars
            .filter { car ->
                car.position == maxPosition
            }.map { it.showName() }
    }
}
