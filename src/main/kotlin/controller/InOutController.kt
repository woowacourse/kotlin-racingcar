package controller

import constant.ErrorConstant
import data.Car
import view.InOutView

class InOutController(val inOutView: InOutView) {
    fun getCarName(): MutableList<Car> {
        val input = inOutView.getCarNames()
        val carNames = input.split(",")
        val cars: MutableList<Car> = mutableListOf()

        carNames.forEach { car ->
            if (cars.find { it.name == car } != null) throw IllegalArgumentException(ErrorConstant.ERROR_SAME_NAME)
            cars.add(Car(car))
        }

        return cars
    }
}