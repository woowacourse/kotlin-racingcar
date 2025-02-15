package controller

import domain.Car
import utils.MoveConditionGenerator.getMoveConditionByNumber
import validator.InputValidator
import view.InputView
import view.OutputView

class RacingController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    fun run() {
        val carNames: List<String> = getCarNames()
        val cars: List<Car> = carNames.map { Car(it) }
        val tryNumber: Int = getTryNumber()

        outputView.printStatus()
        repeat(tryNumber) {
            playRace(cars)
            outputView.printCars(cars)
        }
        outputView.printResult(getWinners(cars))
    }

    private fun getCarNames(): List<String> {
        return inputView.inputCarNames().split(DELIMITER).map { it.trim() }
    }

    private fun getTryNumber(): Int {
        return InputValidator.validateTryNumber(inputView.inputTryNumber())
    }

    private fun playRace(cars: List<Car>) {
        for (car in cars) {
            car.moveOrStop(getMoveConditionByNumber((MIN_RANGE..MAX_RANGE).random()))
        }
    }

    private fun getWinners(cars: List<Car>): List<String> {
        return cars.filter { car -> car.position == cars.maxOf { it.position } }.map { it.name }
    }

    companion object {
        private const val DELIMITER = ','
        private const val MIN_RANGE = 0
        private const val MAX_RANGE = 9
    }
}
