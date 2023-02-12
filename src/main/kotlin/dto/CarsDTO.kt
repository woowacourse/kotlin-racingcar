package dto

import domain.Car
import domain.RandomNumberGenerator

class CarsDTO(input: String) {
    private var cars = mutableListOf<Car>()
    private var names: List<String>
    private val numberGenerator = RandomNumberGenerator()

    init {
        names = input.split(',')

        verifyCarCount()
        names.map { name ->
            verifyName(name)
            verifyNameLength(name)
        }
        verifyCarUniqueness()

        makeCars()
    }

    fun getCars(): List<Car> {
        return cars
    }

    private fun makeCars() {
        names.map { name -> cars.add(Car(numberGenerator, name)) }
    }

    private fun verifyCarCount() {
        require(names.size in 2..20) { ERROR_CAR_COUNT }
    }

    private fun verifyName(name: String) {
        name.map { require(it.code in 97..122) { ERROR_NAME } }
    }

    private fun verifyNameLength(name: String) {
        require(name.length in 1..5) { ERROR_NAME_LENGTH }
    }

    private fun verifyCarUniqueness() {
        require(names.size == names.toSet().size) { ERROR_CAR_UNIQUENESS }
    }

    companion object {
        const val ERROR_CAR_COUNT = "자동차 개수는 2대 이상 20대 이하여야 합니다."
        const val ERROR_CAR_UNIQUENESS = "자동차 이름은 중복되면 안 됩니다."
        const val ERROR_NAME = "자동차 이름은 공백이 없는 영문 소문자여야 합니다."
        const val ERROR_NAME_LENGTH = "자동차 이름은 1글자 이상 5글자 이하여야 합니다."
    }
}
