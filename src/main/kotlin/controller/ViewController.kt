package controller

import constant.ErrorConstant
import constant.MessageConstant
import model.Car
import view.InputView
import view.OutputView

class ViewController(private val inputView: InputView, private val outputView: OutputView) {
    fun getCarName(): List<Car> {
        val input = inputView.getUserInput(MessageConstant.INPUT_NAME)
        val carNames = splitToComma(input)
        validateName(carNames)
        val cars = carNames.map { Car(it) }
        return cars
    }

    private fun splitToComma(input: String): List<String> {
        val carNames = input.split(",").filter { it.isNotEmpty() }
        return carNames
    }

    private fun validateName(name: List<String>) {
        if (name.isEmpty()) throw java.lang.IllegalArgumentException(ErrorConstant.ERROR_NO_NAME)
        if (name.toSet().size != name.size) throw IllegalArgumentException(ErrorConstant.ERROR_SAME_NAME)
    }

    fun getTryCount(): Int {
        val input = inputView.getUserInput(MessageConstant.INPUT_COUNT)
        val count = parseInt(input)
        validateCount(count)
        return count!!
    }

    private fun parseInt(input: String): Int? {
        val count = input.toIntOrNull()
        return count
    }

    private fun validateCount(count: Int?) {
        if (count == null) throw IllegalArgumentException(ErrorConstant.ERROR_UNDER_ZERO)
        if (count <= 0) throw IllegalArgumentException(ErrorConstant.ERROR_UNDER_ZERO)
    }

    fun printCurrentPosition(cars: List<Car>) {
        cars.forEach { car ->
            outputView.printCurrentResult(car)
        }
        println()
    }

    fun printGameResult() {
        outputView.printGameResult()
    }

    fun printFinalResult(winnerResult: List<Car>) {
        outputView.printFinalResult(winnerResult)
    }
}
