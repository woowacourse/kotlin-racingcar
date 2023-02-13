package racingcar.racingcar.domain.numbergenerator

interface NumberGenerator {
    fun generateNumber(minNumber: Int, maxNumber: Int): Int
}
