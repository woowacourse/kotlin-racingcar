package domain

class Cars private constructor(val cars: List<Car>) {
    fun startPhaseWith(moveStrategy: MoveStrategy) {
        cars.forEach {
            moveStrategy.move(it)
        }
    }

    companion object {
        fun from(input: String) =
            input.validateCars()
                .map { Car(it) }
                .run { Cars(this) }
    }
}

fun String.validateCars(): List<String> {
    val carNames = this.split(",")
    require(carNames.size == carNames.toSet().size) { EXCEPTION_DUPLICATED_NAME }
    return carNames
}

const val EXCEPTION_DUPLICATED_NAME = "중복된 이름이 존재합니다."
