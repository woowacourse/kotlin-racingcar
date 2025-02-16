package controller

import constant.ErrorConstant
import constant.InOutConstants
import model.Car
import model.Random

import view.InView

class InController(private val inView: InView) {
    fun getCarName(): MutableList<Car> {
        val input = inView.getData(InOutConstants.NAME)
        val carNames = splitToComma(input)
        val cars = carNames.map { Car(it, randomMaker = Random()) }.toMutableList()
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
        val input = inView.getData(InOutConstants.COUNT)
        val count = parseInt(input)
        return count
    }

    fun parseInt(input: String): Int {
        val count = input.toIntOrNull() ?: throw IllegalArgumentException(ErrorConstant.ERROR_NOT_NUMBER)
        if (count <= 0) throw IllegalArgumentException(ErrorConstant.ERROR_UNDER_ZERO)
        return count
    }
}
