package controller

import domain.Car
import utils.RandomGenerator
import view.InputView
import view.OutputView

class RacingController(private val inputView: InputView, private val outputView: OutputView) {
    private lateinit var carNames: List<String>
    private var tryNumber: Int = 0
    private lateinit var cars: List<Car>

    fun run() {
        carNames = splitCarNames(inputView.inputCarNames())
        validateCarNames(carNames)
        tryNumber = validateTryNumber(inputView.inputTryNumber())

        cars = carNames.map { Car(it, 0) }

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

    private fun validateCarNames(splitCarNames: List<String>) {
        require(splitCarNames.all { it.length <= 5 }) { "각 자동차 이름은 5자를 초과할 수 없습니다." }
        require(splitCarNames.all { it.isNotBlank() }) { "각 자동차 이름은 공백이 불가합니다." }
        require(splitCarNames.size == splitCarNames.toSet().size) { "각 자동차 이름은 중복이 불가합니다." }
    }

    private fun validateTryNumber(inputTryNumber: String): Int {
        return try {
            inputTryNumber.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(e)
        }
    }

    companion object {
        const val DELIMITER = ','
    }
}
