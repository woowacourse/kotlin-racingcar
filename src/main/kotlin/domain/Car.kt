package domain

import data.ComparisonResult
import dto.CarMetadataDTO

class Car(
    private val generator: NumberGenerator,
    private val name: String,
    private var distance: Int = 0
) {

    init {
        validateCarName()
    }

    fun race(): CarMetadataDTO {
        val number = generator.generate()
        if (checkGo(number)) go()
        return CarMetadataDTO(ComparisonResult.NONE, distance, name)
    }

    fun compare(winnerDistance: Int): CarMetadataDTO {
        val difference = distance - winnerDistance
        val comparisonResult = when {
            difference > 0 -> ComparisonResult.WIN
            difference < 0 -> ComparisonResult.LOSE
            else -> ComparisonResult.DRAW
        }

        return CarMetadataDTO(comparisonResult, distance, name)
    }

    private fun checkGo(number: Int): Boolean {
        if (number in RANGE_LOWER_INCLUSIVE..RANGE_UPPER_INCLUSIVE)
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
        const val RANGE_UPPER_INCLUSIVE = 9

        const val ERROR_NAME_LENGTH = "자동차 이름은 1글자 이상 5글자 이하여야 합니다."
        const val ERROR_NAME = "자동차 이름은 공백이 없는 영문 소문자여야 합니다."
    }
}
