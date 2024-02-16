package model

import util.NumberGenerator

class CarsManager(private val randomNumber: NumberGenerator) {

    lateinit var cars: List<Car>
        private set

    fun create(carsName: List<String>) {
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