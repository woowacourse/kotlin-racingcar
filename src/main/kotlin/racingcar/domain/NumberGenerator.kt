package racingcar.domain

interface NumberGenerator {
    fun generateNumber(MIN_NUMBER: Int, MAX_NUMBER: Int): Int
}
