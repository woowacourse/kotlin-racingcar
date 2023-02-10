package domain

import data.Car
import data.CarPath
import data.generator.CarGenerator
import util.RESULT
import view.InputView
import view.OutputView

class CarRacingGameController(
    private val carRacingGame: CarRacingGame = CarRacingGame(),
    private val carGenerator: CarGenerator = CarGenerator()
) {

    fun startGame() {
        try {
            val cars = initCars()
            val numberOfTry = initNumberOfTry()
            val carsPath = carRacingGame.startDriving(cars, numberOfTry)

            showPath(carsPath, numberOfTry)
            showWinner(cars)
        } catch (e: IllegalArgumentException) {
            OutputView.printMsg(e.message!!)
        }
    }

    private fun initCars(): List<Car> {
        val names = InputView.inputCarNames().split(',')

        return carGenerator.generateCars(names)
    }

    private fun initNumberOfTry(): Int {
        val numberOfTry = InputView.inputNumberOfTry()

        InputValidator.validateIsNumeric(numberOfTry)

        return numberOfTry.toInt()
    }

    private fun showWinner(cars: List<Car>) {
        OutputView.printWinner(carRacingGame.decideWinner(cars))
    }

    private fun showPath(carsPath: List<CarPath>, numberOfTry: Int) {
        OutputView.printMsg(RESULT)

        repeat(numberOfTry) { number ->
            OutputView.printResult(carsPath, number)
        }
    }
}
