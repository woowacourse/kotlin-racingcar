package model

import generator.NumberGenerator

class Cars(cars: List<Car>, private val numberGenerator: NumberGenerator) {

    init {
        require(cars.map { it.name }.toSet().size == cars.size) { CAR_NAME_OVERLAP_ERROR_MESSAGE }
        require(cars.size in CARS_MIN_LIMIT_SIZE..CARS_MAX_LIMIT_SIZE) { CARS_SIZE_ERROR_MESSAGE }
    }

    var cars: List<Car> = cars.toList()
        get() = field

    fun move() {
        cars.forEach { it.move(numberGenerator.generate()) }
    }

    fun findWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        if (maxPosition == 0) return emptyList()
        return cars.filter { it.position == maxPosition }.map { it.name }
    }

    companion object {
        fun mappingCars(input: String, numberGenerator: NumberGenerator) = Cars(input.split(",").mapIndexed { _, name -> Car(name.trim()) }, numberGenerator)
        const val CAR_NAME_OVERLAP_ERROR_MESSAGE = "자동차 이름이 중복되었습니다."
        const val CARS_MIN_LIMIT_SIZE = 2
        const val CARS_MAX_LIMIT_SIZE = 20
        const val CARS_SIZE_ERROR_MESSAGE = "자동차의 수는 2대 이상 20대 이하여야 합니다."
    }
}
