package racingcar.domain

class Car(val name: String) {
    var position: Int = 0
        private set
  
    fun moveOrStop(randomNumber: Int) {
        if (randomNumber >= MOVE_MIN_RANGE) {
            position++
        }
    }

    companion object {
        private const val MOVE_MIN_RANGE = 4
    }
}
