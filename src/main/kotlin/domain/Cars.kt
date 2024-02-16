package domain

class Cars private constructor(val cars: List<Car>) {
    fun startPhase() {
        cars.forEach {
            // TODO: 제거해야 함
            it.moveIfPossible()
        }
    }

    fun startPhaseWith(moveStrategy: MoveStrategy) {
        cars.forEach {
            moveStrategy.move(it)
        }
    }

    companion object {
        fun from(
            input: String,
            numberGenerator: NumberGenerator,
        ) = input.validateCars()
            .map { Car(it, numberGenerator) }
            .run { Cars(this) }
    }
}

fun String.validateCars(): List<String> {
    val carNames = this.split(",")
    require(carNames.size == carNames.toSet().size) { EXCEPTION_DUPLICATED_NAME }
    return carNames
}

const val EXCEPTION_DUPLICATED_NAME = "중복된 이름이 존재합니다."
