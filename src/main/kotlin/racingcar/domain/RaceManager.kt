package racingcar.domain

import racingcar.racingcar.domain.CarFactory
import racingcar.racingcar.domain.raceresult.RaceResult

class RaceManager(
    private val numberGenerator: NumberGenerator,
) {
    fun race(carFactory: CarFactory, raceCount: Int): RaceResult {
        repeat(raceCount) { carFactory.moveCars(numberGenerator) }
        return RaceResult(carFactory.carNames, carFactory.record)
    }

    fun getWinners(carFactory: CarFactory): List<String> {
        return carFactory.cars
            .filter { car -> car.location == carFactory.maxLocation }
            .map { car -> car.name }
    }
}
