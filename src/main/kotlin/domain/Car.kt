package domain

import dto.RaceResultDTO

class Car(
    private val generator: NumberGenerator,
    val name: String,
    private var distance: Int = 0
) {

    init {
        validateCarName()
    }

    fun race(): RaceResultDTO {
        val number = generator.generate()
        if (checkGo(number)) go()
        return RaceResultDTO(distance, name)
    }

    fun getDistance() = distance

    private fun checkGo(number: Int): Boolean {
        if (number >= RANGE_LOWER_INCLUSIVE)
            return true
        return false
    }

    private fun go() {
        distance++
    }

    private fun validateCarName() {
        require(name.length in NAME_LOWER_LENGTH..NAME_UPPER_LENGTH) { ERROR_NAME_LENGTH }
        name.forEach { require(it.code in NAME_LOWER_LETTER..NAME_UPPER_LETTER) { ERROR_NAME } }
    }

    companion object {
        const val NAME_LOWER_LENGTH = 1
        const val NAME_UPPER_LENGTH = 5

        const val NAME_LOWER_LETTER = 97
        const val NAME_UPPER_LETTER = 122

        const val RANGE_LOWER_INCLUSIVE = 4

        const val ERROR_NAME_LENGTH = "자동차 이름은 1글자 이상 5글자 이하여야 합니다."
        const val ERROR_NAME = "자동차 이름은 공백이 없는 영문 소문자여야 합니다."
    }
}
