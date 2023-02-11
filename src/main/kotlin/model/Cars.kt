package model

import generator.NumberGenerator

class Cars(cars: List<Car>, private val numberGenerator: NumberGenerator) {

    var cars: List<Car> = cars
        get() = field

    fun move() {
        cars.forEach { it.move(numberGenerator.generateNumber()) }
    }

    private fun findMaxPosition(): Int {
        return cars.maxByOrNull {
            it.position
        }!!.position
    }

    fun findWinners(): List<String> {
        val maxEqualCars = cars.filter {
            it.position == findMaxPosition()
        }.toList()
        return maxEqualCars.map { it.name }
    }

    companion object {
        fun mappingCars(input: String, numberGenerator: NumberGenerator) = Cars(input.split(",").mapIndexed { _, name -> Car(name.trim()) }, numberGenerator)
    }
}
