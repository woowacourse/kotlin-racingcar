package data

import data.generator.RacingNumberGenerator

class CarRacingGamePlayer(
    private val car: Car,
    private val numberOfTry: Int
) {

    fun moveCar(): CarPath {
        val path = mutableListOf<PathState>()

        repeat(numberOfTry) {
            path.add(drive())
        }

        return CarPath(car.getCar().first, path)
    }

    private fun drive(): PathState {
        val randomNumber = RacingNumberGenerator().generate()

        if (randomNumber >= 4) {
            car.move()
            return PathState.MOVE
        }

        return PathState.STOP
    }
}
