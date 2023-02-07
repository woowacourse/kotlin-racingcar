class CarRacing(
    private val inputView: InputView = InputView(),
    private val inputValidator: InputValidator = InputValidator()
) {
    fun play() {
        val cars = initCars()
        val numberOfTry = initNumberOfTry()
        moveCars(numberOfTry, cars)
    }

    private fun initCars(): List<Car> {
        val names = inputView.inputCarNames().split(',')

        names.forEach { name ->
            inputValidator.validateNameLength(name)
        }

        return names.map { name ->
            Car(0, name)
        }
    }

    private fun initNumberOfTry(): Int {
        val numberOfTry = inputView.inputNumberOfTry()

        inputValidator.validateIsNumeric(numberOfTry)

        return numberOfTry.toInt()
    }

    private fun moveCars(numberOfTry: Int, cars: List<Car>) {
        repeat(numberOfTry) {
            moveCar(cars)
        }
    }

    private fun moveCar(cars: List<Car>) {
        cars.forEach { car ->
            car.move()
        }
    }
}
