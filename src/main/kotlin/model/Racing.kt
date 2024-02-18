package model

import util.NumberGenerator

class Racing(carsName: List<String>, private val randomNumber: NumberGenerator) {

    val cars: List<Car>

    init {
        cars = carsName.map { Car(it) }
        checkNameDuplication(carsName)
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

        fun checkNameDuplication(carsName: List<String>) {
            require(carsName.size == carsName.toSet().size) {
                "[ERROR] 자동차 이름은 중복될 수 없습니다."
            }
        }
    }
}
