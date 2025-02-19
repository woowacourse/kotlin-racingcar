package racingcar.domain

class Car(
    val name: String,
    initialDistance: Int = 0,
) {
    var distance: Int = initialDistance
        private set

    fun move(number: Int) {
        if (number >= MOVEMENT_CONDITION) {
            distance += 1
        }
    }

    companion object {
        private const val MOVEMENT_CONDITION: Int = 4
    }
}

fun String.toCars(): List<Car> =
    split(",")
        .map { it.trim() }
        .filter { it.isNotBlank() }
        .map { name -> Car(name) }
