package model

import util.NumberGenerator

class CarsManager(carsName: List<String>, private val randomNumber: NumberGenerator) {

    var cars: List<Car>
        private set

    init {
        cars = carsName.map { Car(it) }
    }

    fun move() {
        cars.forEach { it.moveForward(isMove()) }
    }

    fun getWinners(): List<String> {
        val maxForwardCount = getMaxForwardCount()
        return cars.filter { it.forwardCount == maxForwardCount }.map { it.name }
    }

    private fun getMaxForwardCount() = cars.maxOfOrNull { it.forwardCount }

    private fun isMove(): Boolean = randomNumber.generate() >= FORWARD_STANDARD_NUMBER

    companion object {
        private const val FORWARD_STANDARD_NUMBER = 4
    }
}
