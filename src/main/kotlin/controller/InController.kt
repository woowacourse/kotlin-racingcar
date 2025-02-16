package controller

import constant.InOutConstants
import dto.CarNames
import dto.TryCount
import model.Car
import model.Random

import view.InView

class InController(private val inView: InView) {
    fun getCarName(): MutableList<Car> {
        val carNames = CarNames(inView.getData(InOutConstants.NAME))
        val cars = carNames.carNamesList.map { Car(it, randomMaker = Random()) }.toMutableList()
        return cars
    }

    fun getTryCount(): Int {
        val input = inView.getData(InOutConstants.COUNT)
        val count = TryCount(input).tryCountNumber
        return count
    }
}
