package controller

import constant.ErrorConstant
import model.Car
import view.InOutConstant
import view.InOutView

class InOutController(private val inOutView: InOutView) {
    fun getCarName(): MutableList<Car> {
        val input = inOutView.getData(InOutConstant.NAME)
        val carNames = splitToComma(input)
        val cars = carNames.map { Car(it) }.toMutableList()
        return cars
    }

    fun splitToComma(input: String): MutableList<String> {
        val carNames = input.split(",").map { it.trim() }.filter { it.isNotBlank() }
        if (carNames.isEmpty()) throw IllegalArgumentException(ErrorConstant.ERROR_NO_NAME)
        if (carNames.toSet().size != carNames.size) throw IllegalArgumentException(ErrorConstant.ERROR_SAME_NAME)
        if (carNames.any { it.length > 5 }) throw IllegalArgumentException(ErrorConstant.ERROR_WRONG_NAME_LENGTH)
        return carNames.toMutableList()
    }

    fun getTryCount(): Int {
        val input = inOutView.getData(InOutConstant.COUNT)
        val count = parseInt(input)
        return count
    }

    fun parseInt(input: String): Int {
        val count = input.toIntOrNull()
        if (count == null) throw IllegalArgumentException(ErrorConstant.ERROR_NOT_NUMBER)
        if (count <= 0) throw IllegalArgumentException(ErrorConstant.ERROR_UNDER_ZERO)
        return count
    }

    fun printCurrentPosition(cars: MutableList<Car>) {
        cars.forEach { car ->
            inOutView.printCurrentResult(car)
        }
        println()
    }

    fun printGameResult() {
        inOutView.printGameResult()
    }

    fun printFinalResult(winnerResult: MutableList<Car>) {
        inOutView.printFinalResult(winnerResult)
    }
}
