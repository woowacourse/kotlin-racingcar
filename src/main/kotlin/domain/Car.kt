package domain

class Car(val carName: String, private val driver: Driver) {

    private var _distance = ""
    val distance get() = _distance

    init {
        require(carName.length in RANGE) { NAME_CONVENTION_ERROR_MESSAGE }
    }

    fun decideCarMovement() {
        val decision = driver.decideMovement()
        _distance += decision.distance
    }

    companion object {
        const val NAME_CONVENTION_ERROR_MESSAGE = "[ERROR] 이름은 1~5글자여야합니다."
        private const val NAME_LENGTH_LOWER_INCLUSIVE = 1
        private const val NAME_LENGTH_UPPER_INCLUSIVE = 5
        val RANGE = NAME_LENGTH_LOWER_INCLUSIVE..NAME_LENGTH_UPPER_INCLUSIVE
    }
}
