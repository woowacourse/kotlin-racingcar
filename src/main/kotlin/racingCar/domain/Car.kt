package racingCar.domain

class Car(val name: Name, private val numberGenerator: NumberGenerator) {

    var position: Int = 0
        private set

    fun move() {
        if (isMovable()) {
            position++
        }
    }

    private fun isMovable() = numberGenerator.generate() >= 4
}
