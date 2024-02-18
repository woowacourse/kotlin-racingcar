package racingcar.model

import racingcar.constants.GameConstants

class Car(private val name: String) : Comparable<Car> {
    var position: Int = 0
        private set

    fun tryForward(randomNumber: Int) {
        if (randomNumber >= GameConstants.FORWARD_FLAG_NUMBER) {
            forward()
        }
    }

    fun forward() {
        position++
    }

    override fun toString() = name

    override fun compareTo(other: Car) =
        other.position.compareTo(this.position)
}
