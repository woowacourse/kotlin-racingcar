class CarRacer(
    private val car: Car,
    private val numberOfTry: Int
) {

    private fun moveCar() {
        repeat(numberOfTry) {
            drive()
        }
    }

    private fun drive() {
        val randomNumber = RacingNumberGenerator().generate()

        if (randomNumber >= 4) {
            car.move()
        }
    }
}
