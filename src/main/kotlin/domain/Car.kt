package domain

import dto.RaceResult
import kotlin.math.max

class Car(
    private val generator: NumberGenerator,
    private val name: String,
    private var distance: Int = 0
) {
    init {
        verifyName(name)
        verifyNameLength(name)
    }

    fun race(): RaceResult {
        val number = generator.generate()
        if (checkGo(number)) go()
        return RaceResult(distance, name)
    }

    fun compareDistance(winnerDistance: Int): Int {
        return max(winnerDistance, distance)
    }

    fun isWinner(winnerDistance: Int): String {
        if (winnerDistance == distance) {
            return name
        }
        return ""
    }

    private fun verifyName(name: String) {
        name.forEach {
            require(it.code in 97..122) { "$ERROR_NAME\n잘못된 자동차 이름 : $name" }
        }
    }

    private fun verifyNameLength(name: String) {
        require(name.length in 1..5) { "$ERROR_NAME_LENGTH\n잘못된 자동차 이름 : $name" }
    }

    private fun checkGo(number: Int): Boolean {
        return number in RANGE_LOWER_INCLUSIVE..RANGE_UPPER_INCLUSIVE
    }

    private fun go() {
        distance++
    }

    companion object {
        const val ERROR_NAME = "자동차 이름이 공백이 없는 영문 소문자가 아닙니다."
        const val ERROR_NAME_LENGTH = "자동차 이름이 1글자 이상 5글자 이하가 아닙니다."
        const val RANGE_LOWER_INCLUSIVE = 4
        const val RANGE_UPPER_INCLUSIVE = 9
    }
}
