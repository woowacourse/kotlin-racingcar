package controller

import domain.Car
import utils.RandomGenerator
import validator.InputValidator
import view.InputView
import view.OutputView

class RacingController(private val inputView: InputView, private val outputView: OutputView) {
    private lateinit var carNames: List<String>
    private var tryNumber: Int = 0
    private lateinit var cars: List<Car>

    fun run() {
        carNames = splitCarNames(inputView.inputCarNames())
        carNames.forEach { InputValidator.validateCarName(it) }
        InputValidator.validateDuplicatedName(carNames)
        tryNumber = InputValidator.validateTryNumber(inputView.inputTryNumber())

        cars = carNames.map { Car(it) }

        outputView.printStatus()

        repeat(tryNumber) {
            cars.forEach { it.move(RandomGenerator.generateRandomNumber()) }
            outputView.printCars(cars)
        }
        outputView.printResult(cars.filter { car -> car.position == cars.maxOf { it.position } }.map { it.name })
    }

    private fun splitCarNames(inputCarNames: String): List<String> {
        return inputCarNames.split(DELIMITER)
    }

    companion object {
        const val DELIMITER = ','
    }
}
