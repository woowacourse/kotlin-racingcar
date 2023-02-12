package model

import generator.NumberGenerator

class Cars(cars: List<Car>, private val numberGenerator: NumberGenerator) {

    init {
        require(cars.toSet().size == cars.size) { CAR_NAME_OVERLAP_ERROR_MESSAGE }
    }

    var cars: List<Car> = cars.toList()
        get() = field

    fun move() {
        cars.forEach { it.move(numberGenerator.generate()) }
    }

    fun findWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }

    companion object {
        fun mappingCars(input: String, numberGenerator: NumberGenerator) = Cars(input.split(",").mapIndexed { _, name -> Car(name.trim()) }, numberGenerator)
        const val CAR_NAME_OVERLAP_ERROR_MESSAGE = "자동차 이름이 중복되었습니다."
    }
}
