package racingcar.domain

class RandomNumberGenerator : NumberGenerator {
    override fun generateNumber(minNumber: Int, maxNumber: Int): Int {
        return (minNumber..maxNumber).random()
    }
}
