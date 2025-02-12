package model

class Race(
    private val cars: Cars,
    private val numberGenerator: NumberGenerator = RandomNumberGenerator()
) {
    fun playOneRound() {
        cars.parsedCars.forEach { car ->
            car.moveForward(numberGenerator.generate())
        }
    }

    fun getWinner(): List<String> {
        val maxPosition = cars.parsedCars.maxOf { it.position }
        val winners = cars.parsedCars.filter { it.position == maxPosition }
            .map { it.name }

        return winners
    }
}
