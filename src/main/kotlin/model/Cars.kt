package model

class Cars(val cars: List<Car>) {
    constructor(input: String) : this(input.split(",").mapIndexed { _, name -> Car(name.trim()) })
    fun getCar(index: Int): Car = cars[index]
    fun getCarSize(): Int = cars.size
    fun move(index: Int, condition: Int) {
        cars[index].move(condition)
    }
}
