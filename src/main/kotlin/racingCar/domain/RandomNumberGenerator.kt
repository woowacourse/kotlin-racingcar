package racingCar.domain

class RandomNumberGenerator : NumberGenerator {
    override fun generate(): Int {
        return (MIN..MAX).random()
    }

    companion object {
        private const val MIN: Int = 0
        private const val MAX: Int = 9
    }
}
