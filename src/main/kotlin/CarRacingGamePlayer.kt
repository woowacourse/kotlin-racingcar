class CarRacingGamePlayer(
    private val car: Car,
    private val numberOfTry: Int
) {

    private fun moveCar(): List<PathState> {
        val path = mutableListOf<PathState>()
        repeat(numberOfTry) {
            path.add(drive())
        }

        return path.toList()
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
