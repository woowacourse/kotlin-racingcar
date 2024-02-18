package racingcar.model

import racingcar.validator.Validation
import kotlin.random.Random

class Car(val name: String, var position: Int = INITIAL_POSITION) {

    private fun getRandomNumber(): Int = Random.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)

    fun move() {
        if (getRandomNumber() >= MIN_POSITION_CONDITION) position++
    }

    companion object {
        private const val MIN_RANDOM_NUMBER = 0
        private const val MAX_RANDOM_NUMBER = 9
        private const val MIN_POSITION_CONDITION = 4
        private const val INITIAL_POSITION = 0
    }
}
