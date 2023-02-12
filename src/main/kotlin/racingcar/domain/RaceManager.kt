package racingcar.domain

import racingcar.racingcar.domain.Cars
import racingcar.racingcar.domain.numbergenerator.NumberGenerator
import racingcar.racingcar.domain.raceresult.RaceResult
import racingcar.racingcar.domain.raceresult.RacerResult
import racingcar.racingcar.domain.raceresult.StepResult

class RaceManager(
    private val numberGenerator: NumberGenerator,
) {
    fun race(cars: Cars, raceCount: Int): RaceResult {
        val stepResults = (1..raceCount).map { cars.move(numberGenerator) }
        return RaceResult(stepResults)
    }

    private fun Cars.move(numberGenerator: NumberGenerator): StepResult {
        val racers = this.cars.map { car ->
            car.move(numberGenerator.generateNumber(Car.MIN_BOUNDARY, Car.MAX_BOUNDARY))
            RacerResult(car.name, car.location)
        }
        return StepResult(racers)
    }

    fun getWinners(cars: Cars): List<String> {
        return cars.cars
            .filter { car -> car.location == cars.maxLocation }
            .map { car -> car.name }
    }
}
