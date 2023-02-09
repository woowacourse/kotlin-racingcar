package data

import data.generator.NumberGenerator
import data.generator.RacingNumberGenerator

class CarRacingGamePlayer(
    private val car: Car,
    private val numberOfTry: Int,
    private val numberGenerator: NumberGenerator = RacingNumberGenerator()
) {

    fun moveCar(): CarPath {
        val path = mutableListOf<PathState>()

        repeat(numberOfTry) {
            path.add(drive())
        }

        return CarPath(car.getCar().first, path)
    }

    private fun drive(): PathState {
        val randomNumber = numberGenerator.generate()

        if (randomNumber >= 4) {
            car.move()
            return PathState.MOVE
        }

        return PathState.STOP
    }
}
