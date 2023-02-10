package racingcar.domain

interface NumberGenerator {
    fun generateNumber(minNumber: Int, maxNumber: Int): Int
}
