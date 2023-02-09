package domain

import data.Car
import data.CarPath
import data.CarRacingGamePlayer
import data.generator.CarGenerator
import data.generator.CarRacingGamePlayerGenerator
import util.RESULT
import view.InputView
import view.OutputView

class CarRacingGameController(
    private val carRacingGame: CarRacingGame = CarRacingGame(),
    private val carGenerator: CarGenerator = CarGenerator(),
    private val carRacingGamePlayerGenerator: CarRacingGamePlayerGenerator = CarRacingGamePlayerGenerator()
) {

    fun startGame() {
        val cars = initCars()
        val numberOfTry = initNumberOfTry()
        val players = initPlayers(cars, numberOfTry)
        val carsPath = carRacingGame.startDriving(players)

        showPath(carsPath, numberOfTry)
        showWinner(cars)
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

    private fun initPlayers(cars: List<Car>, numberOfTry: Int): List<CarRacingGamePlayer> =
        carRacingGamePlayerGenerator.generateCarRacers(cars, numberOfTry)

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
