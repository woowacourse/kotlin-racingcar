package model

import generator.RandomGenerator

class Cars(cars: List<Car>) {

    var cars: List<Car> = cars
        get() = cars

    fun move() {
        cars.forEach { it.move(RandomGenerator().getRandomNumber()) }
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
        fun mappingCars(input: String) = Cars(input.split(",").mapIndexed { _, name -> Car(name.trim()) })
    }
}
