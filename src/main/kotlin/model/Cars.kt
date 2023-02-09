package model

import generator.RandomGenerator

class Cars(input: String) {
    private val cars: List<Car>

    init {
        this.cars = mappingCars(input)
    }

    private fun mappingCars(input: String): List<Car> = input.split(",").mapIndexed { _, name -> Car(name.trim()) }
    fun getCar(position: Int): Car = cars[position]
    fun getCarSize(): Int = cars.size

    fun move(position: Int) {
        cars[position].move(RandomGenerator().getRandomNumber())
    }

    private fun findMaxPosition(): Int {
        return cars.sortedByDescending {
            it.getInfo().second
        }.maxByOrNull {
            it.getInfo().second
        }!!.getInfo().second
    }

    fun findWinners(): List<String> {
        val maxValue = findMaxPosition()
        val maxEqualCars = cars.filter {
            it.getInfo().second == maxValue
        }.toList()
        val names = mutableListOf<String>()
        for (car in maxEqualCars) {
            names.add(car.getInfo().first)
        }
        return names
    }
}
