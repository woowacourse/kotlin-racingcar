package domain

class Cars private constructor(val cars: List<Car>) {
    fun startPhaseWith(moveStrategy: MoveStrategy) {
        cars.forEach {
            moveStrategy.move(it)
        }
    }

    override fun toString(): String {
        return "Cars(cars=$cars)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Cars

        if (cars != other.cars) return false

        return true
    }

    override fun hashCode(): Int {
        return cars.hashCode()
    }

    companion object {
        fun from(input: String) =
            input.validateCars()
                .map { Car(it) }
                .run { Cars(this) }
    }
}

private fun String.validateCars(): List<String> {
    val carNames = this.split(",")
    require(carNames.size == carNames.toSet().size) { EXCEPTION_DUPLICATED_NAME }
    return carNames
}

private const val EXCEPTION_DUPLICATED_NAME = "중복된 이름이 존재합니다."
