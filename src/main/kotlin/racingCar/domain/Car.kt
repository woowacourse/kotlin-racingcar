package racingCar.domain

class Car(val name: Name, private val numberGenerator: NumberGenerator) {

    var position: Int = 0

    fun move() {
        if (isMovable()) {
            position++
        }
    }

    private fun isMovable() = numberGenerator.generate() >= 4
}
