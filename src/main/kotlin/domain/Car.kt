package domain

class Car(val carName: String, private val driver: Driver) {
    private var _distance = ""
    val distance get() = _distance

    fun decideCarMovement() {
        val decision = driver.decideMovement()
        _distance += decision.distance
    }
}
