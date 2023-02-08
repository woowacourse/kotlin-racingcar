
class CarRacing(
    private val referee: Referee = Referee(),
    private val carGenerator: CarGenerator = CarGenerator(),
    private val inputValidator: InputValidator = InputValidator()
) {

    fun play() {
        val cars = initCars()
        val numberOfTry = initNumberOfTry()
        moveCars(numberOfTry, cars)
        showWinner(cars)
    }

    private fun initCars(): List<Car> {
        val names = InputView.inputCarNames().split(',')

        return carGenerator.generateCars(names)
    }

    private fun initNumberOfTry(): Int {
        val numberOfTry = InputView.inputNumberOfTry()

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

    private fun showWinner(cars: List<Car>) {
        OutputView.printWinner(referee.decideWinner(cars))
    }

    private fun showResult(cars: List<Car>) {
        OutputView.printResult(cars)
    }
}
