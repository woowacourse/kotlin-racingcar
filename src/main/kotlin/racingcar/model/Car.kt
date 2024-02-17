package racingcar.model

import kotlin.random.Random

data class Car(val name: String, var position: Int = INITIAL_POSITION) {
    init {
        require(name.isNotEmpty()) { ERROR_CAR_NAME_BLANK }
        require(name.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH) { ERROR_CAR_NAME_OUT_OF_RANGE }
        require(!name.contains(SPACE)) { ERROR_CAR_NAME_CONTAINS_SPACE }
    }

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
