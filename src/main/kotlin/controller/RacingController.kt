package controller

import domain.Car
import utils.RandomGenerator
import validator.InputValidator
import view.InputView
import view.OutputView

class RacingController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    fun run() {
        val carNames: List<String> = splitCarNames(inputView.inputCarNames())
        val cars: List<Car> = carNames.map { Car(it) }
        val tryNumber = InputValidator.validateTryNumber(inputView.inputTryNumber())

        outputView.printStatus()
        repeat(tryNumber) {
            playRace(cars)
            outputView.printCars(cars)
        }
        outputView.printResult(getWinners(cars))
    }

    private fun splitCarNames(inputCarNames: String): List<String> {
        return inputCarNames.split(DELIMITER).map { it.trim() }
    }

    private fun playRace(cars: List<Car>) {
        for (car in cars) {
            if (RandomGenerator.getRandomNumber(MIN_RANGE, MAX_RANGE) >= MOVE_CONDITION) {
                car.move()
            }
        }
    }

    private fun getWinners(cars: List<Car>): List<String> {
        return cars.filter { car -> car.position == cars.maxOf { it.position } }.map { it.name }
    }

    companion object {
        private const val DELIMITER = ','
        private const val MIN_RANGE = 0
        private const val MAX_RANGE = 9
        private const val MOVE_CONDITION = 4
    }
}
