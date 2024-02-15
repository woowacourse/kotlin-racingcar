package domain

class Cars private constructor(val cars: List<Car>) {

    fun startPhase() {
        cars.forEach {
            it.moveIfPossible()
        }
    }

    companion object {
        fun from(input: String, numberGenerator: NumberGenerator) =
            input.validateCars()
                .map { Car(it, numberGenerator) }
                .run { Cars(this) }
    }
}

fun String.validateCars(): List<String> {
    val carNames = this.split(",")
    require(carNames.size == carNames.toSet().size) { "중복된 이름이 존재합니다." }
    return carNames
}