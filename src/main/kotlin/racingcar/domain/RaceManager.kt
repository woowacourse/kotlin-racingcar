package racingcar.domain

import racingcar.racingcar.domain.Cars
import racingcar.racingcar.domain.numbergenerator.NumberGenerator
import racingcar.racingcar.domain.raceresult.RaceResult
import racingcar.racingcar.domain.raceresult.StepResult

class RaceManager(
    private val numberGenerator: NumberGenerator,
) {
    fun race(cars: Cars, raceCount: Int): RaceResult {
        val carLocations = (1..raceCount).map { cars.move(numberGenerator) }
        return RaceResult(cars.names, carLocations.map(::StepResult))
    }

    private fun Cars.move(numberGenerator: NumberGenerator): List<Int> {
        this.cars.forEach { car -> car.move(numberGenerator.generateNumber(Car.MIN_BOUNDARY, Car.MAX_BOUNDARY)) }
        return this.locations
    }

    fun getWinners(cars: Cars): List<String> {
        return cars.cars
            .filter { car -> car.location == cars.maxLocation }
            .map { car -> car.name }
    }
}
