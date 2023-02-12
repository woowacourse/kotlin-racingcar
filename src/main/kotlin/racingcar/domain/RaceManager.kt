package racingcar.domain

import racingcar.racingcar.domain.RaceResultDto

class RaceManager(
    private val numberGenerator: NumberGenerator,
) {
    private var cars: List<Car> = listOf()
    private var raceCount = 0
    private var result = mutableListOf<List<Int>>()

    fun race(): RaceResultDto {
        result = mutableListOf()
        repeat(raceCount) {
            nextStep()
        }
        return RaceResultDto(cars.map { car -> car.name }, result)
    }

    private fun nextStep() {
        cars.forEach { it.move(numberGenerator.generateNumber(Car.MIN_BOUNDARY, Car.MAX_BOUNDARY)) }
        result.add(cars.map { car -> car.location })
    }

    fun setGame(carNames: List<String>, racingCount: Int) {
        this.cars = carNames.map { Car(it) }
        this.raceCount = racingCount
    }

    fun getWinner(): List<String> {
        val maxLocation = cars.maxOf { it.location }
        return cars.filter { car -> car.location == maxLocation }
            .map { it.name }
    }
}
