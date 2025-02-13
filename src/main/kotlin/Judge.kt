class Judge {
    fun isCarAbleToMove(randomNumber: Int): Boolean = randomNumber >= MIN_RANDOM_AVAILABILITY_CONDITION

    fun selectWinners(cars: List<Car>): List<String> {
        val maxPosition = cars.maxOf { car -> car.position }
        return cars
            .filter { car ->
                car.position == maxPosition
            }.map { winner -> winner.name }
    }

    companion object {
        private const val MIN_RANDOM_AVAILABILITY_CONDITION = 4
    }
}
