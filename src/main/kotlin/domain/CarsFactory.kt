package domain

class CarsFactory(private val names: List<String>) {

    init {
        validateCarCount()
        validateCarUniqueness()
    }

    private fun validateCarCount() {
        require(names.size in LOWER_CAR_COUNT..UPPER_CAR_COUNT) { ERROR_CAR_COUNT }
    }

    private fun validateCarUniqueness() {
        require(names.size == names.toSet().size) { ERROR_CAR_UNIQUENESS }
    }

    fun makeCars(numberGenerator: NumberGenerator): List<Car> {
        return names.map { name -> Car(numberGenerator, name) }
    }

    companion object {
        const val LOWER_CAR_COUNT = 2
        const val UPPER_CAR_COUNT = 20

        const val ERROR_CAR_COUNT = "자동차 개수는 2대 이상 20대 이하여야 합니다."
        const val ERROR_CAR_UNIQUENESS = "자동차 이름은 중복되면 안 됩니다."
    }
}
