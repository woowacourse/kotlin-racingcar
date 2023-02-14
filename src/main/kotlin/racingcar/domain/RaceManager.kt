package racingcar.domain

class RaceManager(
    private val numberGenerator: NumberGenerator,
    carNames: List<String>,
    racingCount: Int,
) {
    var cars: List<Car> = listOf()
        private set
    private var raceCount = 0

    init {
        cars = carNames.map { Car(it) }
        this.raceCount = racingCount
    }

    fun race(): List<Car> {
        var roundHistory = listOf<Int>()
        repeat(raceCount) {
            nextStep()
        }
        return cars
    }

    private fun nextStep() {
        cars.forEach { it.move(numberGenerator.generateNumber(Car.MIN_BOUNDARY, Car.MAX_BOUNDARY)) }
    }

    fun getWinner(cars: List<Car>): List<String> {
        val maxLocation = cars.maxOf { it.location }
        return cars.filter { car -> car.location == maxLocation }
            .map { it.name }
    }
}
