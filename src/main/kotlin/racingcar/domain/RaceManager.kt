package racingcar.domain

import racingcar.racingcar.domain.RaceResultDto

class RaceManager(
    private val numberGenerator: NumberGenerator,
    carNames: List<String>,
    racingCount: Int
) {
    var cars: List<Car> = listOf()
        private set
    private var raceCount = 0

    init {
        cars = carNames.map { Car(it) }
        this.raceCount = racingCount
    }

    fun race(): RaceResultDto {
        val roundHistory = mutableListOf<List<Int>>()
        repeat(raceCount) {
            nextStep(roundHistory)
        }
        return RaceResultDto(cars.map { car -> car.name }, roundHistory)
    }

    private fun nextStep(roundHistory: MutableList<List<Int>>): MutableList<List<Int>> {
        cars.forEach { it.move(numberGenerator.generateNumber(Car.MIN_BOUNDARY, Car.MAX_BOUNDARY)) }
        roundHistory.add(cars.map { car -> car.location })
        return roundHistory
    }

    fun getWinner(cars: List<Car>): List<String> {
        val maxLocation = cars.maxOf { it.location }
        return cars.filter { car -> car.location == maxLocation }
            .map { it.name }
    }
}
