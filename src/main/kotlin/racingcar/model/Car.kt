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
        const val ERROR_CAR_NAME_BLANK = "[Error] 자동차 이름은 공란일 수 없습니다."
        const val ERROR_CAR_NAME_OUT_OF_RANGE = "[Error] 자동차 이름은 1자 이상 5자 이내여야 합니다."
        const val ERROR_CAR_NAME_CONTAINS_SPACE = "[Error] 이름에 공백이 없어야 합니다."

        const val SPACE = " "

        const val MIN_NAME_LENGTH = 1
        const val MAX_NAME_LENGTH = 5
        const val MIN_RANDOM_NUMBER = 0
        const val MAX_RANDOM_NUMBER = 9
        const val MIN_POSITION_CONDITION = 4
        const val INITIAL_POSITION = 0
    }
}
