package controller

import domain.CarRacingGame
import domain.InputValidator.validateIsNumeric
import domain.Referee
import model.Car
import model.CarPath
import model.generator.CarGenerator
import view.InputView.inputCarNames
import view.InputView.inputNumberOfTry
import view.OutputView

class RacingCarController(
    private val carRacingGame: CarRacingGame = CarRacingGame(),
    private val carGenerator: CarGenerator = CarGenerator()
) {

    fun startGame() {
        try {
            val cars = initCars(inputCarNames())
            val numberOfTry = validateIsNumeric(inputNumberOfTry())
            val carsPath = carRacingGame.startDriving(cars, numberOfTry)

            showPath(carsPath)
            cars.showWinner()
        } catch (e: IllegalArgumentException) {
            OutputView.printMsg(e.message!!)
        }
    }

    private fun initCars(input: String): List<Car> {
        val names = input.split(SEPARATOR)

        return carGenerator.generateCars(names)
    }

    private fun List<Car>.showWinner() =
        OutputView.printWinner(Referee().decideWinner(this))

    private fun showPath(carsPath: List<CarPath>) {
        OutputView.printMsg(RESULT)
        val numberOfTry = carsPath[0].path.size

        repeat(numberOfTry) { number ->
            OutputView.printResult(carsPath, number)
        }
    }

    companion object {
        const val SEPARATOR = ','
        const val RESULT = "실행 결과\n"
    }
}
