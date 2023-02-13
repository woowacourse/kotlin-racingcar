package racingcar.racingcar.domain.numbergenerator

class RandomNumberGenerator : NumberGenerator {
    override fun generateNumber(minNumber: Int, maxNumber: Int): Int {
        return (minNumber..maxNumber).random()
    }
}
