package controller

import constant.MessageConstant
import model.Car
import validator.InputValidator
import view.InputView
import view.OutputView

class RacingViewController(private val inputView: InputView, private val outputView: OutputView) {
    private val validator: InputValidator = InputValidator()

    fun getCarName(): List<String> {
        val input = inputView.getUserInput(MessageConstant.INPUT_NAME)
        val carNames = splitToComma(input)
        validator.validateName(carNames)
        return carNames
    }

    private fun splitToComma(input: String): List<String> {
        val carNames = input.split(",").filter { it.isNotEmpty() }
        return carNames
    }

    fun getTryCount(): Int {
        val input = inputView.getUserInput(MessageConstant.INPUT_COUNT)
        val count = parseInt(input)
        validator.validateCount(count)
        return count!!
    }

    private fun parseInt(input: String): Int? {
        val count = input.toIntOrNull()
        return count
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
