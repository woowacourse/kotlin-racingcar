import InputView.inputCarNames
import InputView.inputNumberOfTry
import OutputView.printResult
import OutputView.printWinner

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
        val names = inputCarNames().split(',')

        return carGenerator.generateCars(names)
    }

    private fun initNumberOfTry(): Int {
        val numberOfTry = inputNumberOfTry()

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
        printWinner(referee.decideWinner(cars))
    }

    private fun showResult(cars: List<Car>) {
        printResult(cars)
    }
}
