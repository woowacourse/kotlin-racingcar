class CarRacing(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
    private val inputValidator: InputValidator = InputValidator()
) {
    fun play() {
        val cars = initCars()
        val numberOfTry = initNumberOfTry()
        moveCars(numberOfTry, cars)
        showWinner(cars)
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
            showResult(cars)
        }
    }

    private fun moveCar(cars: List<Car>) {
        cars.forEach { car ->
            car.move()
        }
    }

    private fun getWinner(cars: List<Car>): List<Car> {
        val carRacers = cars.sortedByDescending { car ->
            car.getCar().second
        }
        val winner = cars.filter { car ->
            car.getCar().second == carRacers[0].getCar().second
        }
        return winner
    }

    private fun showWinner(cars: List<Car>) {
        outputView.printWinner(getWinner(cars))
    }

    private fun showResult(cars: List<Car>) {
        outputView.printResult(cars)
    }
}
