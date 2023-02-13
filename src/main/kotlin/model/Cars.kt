package model

import generator.RandomGenerator

class Cars(cars: List<Car>) {
    private val _cars: List<Car> = cars
    val cars: List<Car> get() = _cars

    constructor(input: String) : this(input.split(",").mapIndexed { _, name -> Car(name.trim()) })

    fun getCar(index: Int): Car = _cars[index]
    fun getCarSize(): Int = _cars.size
    fun move(index: Int) {
        _cars[index].move(RandomGenerator().getRandomNumber())
    }
}
