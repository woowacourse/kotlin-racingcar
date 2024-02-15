package racingcar.model

import kotlin.random.Random

data class Car(val name: String, var position: Int = INITIAL_POSITION) {
    init {
        require(name.isNotEmpty()) { ERROR_MESSAGE }
        require(name.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH) { ERROR_MESSAGE }
        require(!name.contains(SPACE)) { ERROR_MESSAGE }
    }

    fun getRandomNumber(): Int = Random.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)

    fun move() {
        if (getRandomNumber() >= MIN_POSITION_CONDITION) position++
    }

    companion object {
        const val ERROR_MESSAGE = "잘못된 입력입니다."

        const val SPACE = " "

        const val MIN_NAME_LENGTH = 1
        const val MAX_NAME_LENGTH = 5
        const val MIN_RANDOM_NUMBER = 0
        const val MAX_RANDOM_NUMBER = 9
        const val MIN_POSITION_CONDITION = 4
        const val INITIAL_POSITION = 0
    }
}
