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
        val cars = carNames.map { Car(it) }
        return cars
    }

    fun splitToComma(input: String): List<String> {
        val carNames = input.split(",").filter { it.isNotEmpty() }
        if (carNames.isEmpty()) throw IllegalArgumentException(ErrorConstant.ERROR_NO_NAME)

        if (carNames.toSet().size != carNames.size) throw IllegalArgumentException(ErrorConstant.ERROR_SAME_NAME)
        return carNames
    }

    fun getTryCount(): Int {
        val input = inputView.getUserInput(MessageConstant.INPUT_COUNT)
        val count = parseInt(input)
        return count
    }

    fun parseInt(input: String): Int {
        val count = input.toIntOrNull() ?: throw IllegalArgumentException(ErrorConstant.ERROR_NOT_NUMBER)
        if (count <= 0) throw IllegalArgumentException(ErrorConstant.ERROR_UNDER_ZERO)
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
