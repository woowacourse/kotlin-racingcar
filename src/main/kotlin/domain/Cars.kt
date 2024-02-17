package domain

class Cars private constructor(val cars: List<Car>) {

    fun startPhase() {
        cars.forEach {
            it.moveIfPossible()
        }
    }

    fun getWinners(): Winners {
        val maxPosition = cars.maxOf {
            it.position
        }

        val winners = cars.filter {
            it.position == maxPosition
        }

        return Winners(winners)
    }

    companion object {
        fun from(input: String, numberGenerator: NumberGenerator) =
            validateForm(input)
                .map { Car(it, numberGenerator) }
                .run { Cars(this) }

        private fun validateForm(input: String): List<String> {
            val carNames = input.split(",")
            require(carNames.size == carNames.toSet().size) { EXCEPTION_DUPLICATED_NAME }
            return carNames
        }
    }
}

private const val EXCEPTION_DUPLICATED_NAME = "중복된 이름이 존재합니다."
