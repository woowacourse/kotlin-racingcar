package racingcar.domain

class Car(
    val name: String,
    initialDistance: Int = 0,
) {
    var distance: Int = initialDistance
        private set

    fun move() {
        distance += 1
    }

    companion object {
        const val DISTANCE_SYMBOL: String = "-"
    }
}

fun String.toCars(): List<Car> =
    split(",")
        .map { it.trim() }
        .filter { it.isNotBlank() }
        .map { name -> Car(name) }
