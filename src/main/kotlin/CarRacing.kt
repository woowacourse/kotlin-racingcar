class CarRacing(
    private val inputView: InputView = InputView(),
    private val inputValidator: InputValidator = InputValidator()
) {
    fun play() {
        val cars = initCars()
        val numberOfTry = initNumberOfTry()
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
}
