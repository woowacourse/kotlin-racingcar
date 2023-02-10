package model

import generator.RandomGenerator

class Cars(input: String) {
    private val cars: List<Car>

    init {
        this.cars = mappingCars(input)
    }

    private fun mappingCars(input: String): List<Car> = input.split(",").mapIndexed { _, name -> Car(name.trim()) }
    fun getCarInfo(index: Int): CarInfo = cars[index].getInfo()
    fun getCarSize(): Int = cars.size

    fun move(index: Int) {
        cars[index].move(RandomGenerator().getRandomNumber())
    }

    fun findWinners(): List<String> {
        val equalCars = cars.groupBy({ it.getInfo().position }, { it.getInfo().name })
        return equalCars[equalCars.keys.max()]?.toList() ?: listOf()
    }
}
