package domain

import model.Car
import model.CarPath
import model.PathState
import model.generator.RacingNumberGenerator

class CarRacingGame(
    private val racingNumberGenerator: RacingNumberGenerator = RacingNumberGenerator()
) {

    fun startDriving(cars: List<Car>, numberOfTry: Int): List<CarPath> =
        cars.map { recordPath(it, numberOfTry) }

    private fun recordPath(car: Car, numberOfTry: Int): CarPath {
        val path = mutableListOf<PathState>()

        return CarPath(car.name, path.add(numberOfTry, car))
    }

    private fun MutableList<PathState>.add(repeatNumber: Int, car: Car): List<PathState> {
        repeat(repeatNumber) {
            this.add(car.move(racingNumberGenerator.generate()))
        }
        return this
    }
}
