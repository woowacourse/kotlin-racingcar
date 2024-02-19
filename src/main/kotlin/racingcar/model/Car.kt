package racingcar.model

class Car(val name: String) {
    var position: String = DEFAULT_POSITION
        private set

    fun decideMovement(randomNumber: Int): Boolean = randomNumber in moveIfInThisRange

    fun moveCar(randomNumber: Int) {
        if (decideMovement(randomNumber)) {
            position += POSITION_INDICATOR
        }
    }

    companion object {
        val moveIfInThisRange = 4..9
        const val DEFAULT_POSITION = ""
        const val POSITION_INDICATOR = "-"
    }
}
