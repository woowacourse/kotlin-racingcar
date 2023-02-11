package racingcar.domain

import racingcar.racingcar.domain.CarFactory

class RaceManager(
    private val numberGenerator: NumberGenerator,
) {
    fun race(carFactory: CarFactory, raceCount: Int): CarFactory {
        repeat(raceCount) { carFactory.moveCars(numberGenerator) }
        return carFactory
    }

    fun getWinners(carFactory: CarFactory): List<String> {
        return carFactory.cars
            .filter { car -> car.location == carFactory.maxLocation }
            .map { car -> car.name }
    }
}
