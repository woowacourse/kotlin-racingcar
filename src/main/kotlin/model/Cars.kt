package model

import generator.RandomGenerator

class Cars(input: String) {
    private val cars: List<Car>

    init {
        this.cars = mappingCars(input)
    }

    private fun mappingCars(input: String): List<Car> = input.split(",").mapIndexed { _, name -> Car(name.trim()) }
    fun getCarInfo(position: Int): Pair<String, Int> = cars[position].getInfo()
    fun getCarSize(): Int = cars.size

    fun move(position: Int) {
        cars[position].move(RandomGenerator().getRandomNumber())
    }

    fun findWinners(): List<String> {
        val equalCars = cars.groupBy({ it.getInfo().second }, { it.getInfo().first })
        return equalCars[equalCars.keys.max()]?.toList() ?: listOf()
    }
}
