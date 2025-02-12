package controller

import constant.ErrorConstant
import data.Car
import view.InOutConstant
import view.InOutView

class InOutController(private val inOutView: InOutView) {
    fun getCarName(): MutableList<Car> {
        val input = inOutView.getData(InOutConstant.NAME)
        val carNames = input.split(",").filter { it.isNotEmpty() }
        if (carNames.isEmpty()) throw IllegalArgumentException(ErrorConstant.ERROR_NO_NAME)

        if (carNames.toSet().size != carNames.size) throw IllegalArgumentException(ErrorConstant.ERROR_SAME_NAME)
        val cars = carNames.map { Car(it) }.toMutableList()
        return cars
    }

    fun getTryCount(): Int {
        val input = inOutView.getData(InOutConstant.COUNT).toIntOrNull()
        if (input == null) throw IllegalArgumentException(ErrorConstant.ERROR_NOT_NUMBER)
        if (input <= 0) throw IllegalArgumentException(ErrorConstant.ERROR_UNDER_ZERO)
        return input
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
