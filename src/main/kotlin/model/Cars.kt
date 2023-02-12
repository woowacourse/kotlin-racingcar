package model

import generator.RandomGenerator

class Cars(private val _cars: List<Car>) {
    val cars: List<Car>
        get() = _cars

    constructor(input: String) : this(input.split(",").mapIndexed { _, name -> Car(name.trim()) })

    fun getCar(index: Int): Car = _cars[index]
    fun getCarSize(): Int = _cars.size
    fun move(index: Int) {
        _cars[index].move(RandomGenerator().getRandomNumber())
    }
}
