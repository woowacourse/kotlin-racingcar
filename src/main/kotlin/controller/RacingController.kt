package controller

import domain.Car
import utils.RandomGenerator
import validator.InputValidator
import view.InputView
import view.OutputView

class RacingController(private val inputView: InputView, private val outputView: OutputView) {
    fun run() {
        val carNames: List<String> = splitCarNames(inputView.inputCarNames())
        carNames.forEach { InputValidator.validateCarName(it) }
        InputValidator.validateDuplicatedName(carNames)

        val tryNumber: Int = InputValidator.validateTryNumber(inputView.inputTryNumber())

        val cars: List<Car> = carNames.map { Car(it) }

        outputView.printStatus()

        repeat(tryNumber) {
            cars.forEach { it.move(RandomGenerator.generateRandomNumber()) }
            outputView.printCars(cars)
        }
        outputView.printResult(cars.filter { car -> car.position == cars.maxOf { it.position } }.map { it.name })
    }

    private fun splitCarNames(inputCarNames: String): List<String> {
        return inputCarNames.split(DELIMITER).map { it.trim() }
    }

    companion object {
        const val DELIMITER = ','
    }
}
