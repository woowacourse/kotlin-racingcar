package domain

import data.Car
import data.generator.NumberGenerator
import data.generator.RacingNumberGenerator

class CarRacingGame(
    private val carRacingNumberGenerator: NumberGenerator = RacingNumberGenerator()
) {

    fun moveCars(cars: List<Car>) = cars.forEach { car ->
        car.move(carRacingNumberGenerator.generate())
    }

    fun decideWinner(cars: List<Car>): List<String> {
        val farthestDistance = cars.maxBy { car -> car.position }.position

        val winners = cars.filter { car ->
            car.position == farthestDistance
        }.map { car ->
            car.name
        }

        return winners
    }
}
