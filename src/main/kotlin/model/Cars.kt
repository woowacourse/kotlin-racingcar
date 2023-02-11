package model

import generator.NumberGenerator

class Cars(cars: List<Car>, private val numberGenerator: NumberGenerator) {

    var cars: List<Car> = cars
        get() = field

    fun move() {
        cars.forEach { it.move(numberGenerator.generateNumber()) }
    }

    fun findWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }

    companion object {
        fun mappingCars(input: String, numberGenerator: NumberGenerator) = Cars(input.split(",").mapIndexed { _, name -> Car(name.trim()) }, numberGenerator)
    }
}
