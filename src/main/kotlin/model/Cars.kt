package model

import generator.RandomGenerator

class Cars(private val cars: List<Car>) {
    constructor(input: String) : this(input.split(",").mapIndexed { _, name -> Car(name.trim()) })

    fun getCarInfos(): List<CarInfo> {
        val carInfos = mutableListOf<CarInfo>()
        repeat(cars.size) {
            carInfos.add(cars[it].getInfo())
        }
        return carInfos
    }

    fun getCarInfo(index: Int): CarInfo = cars[index].getInfo()
    fun getCarSize(): Int = cars.size
    fun move(index: Int) {
        cars[index].move(RandomGenerator().getRandomNumber())
    }
}
