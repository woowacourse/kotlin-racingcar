package racingcar.model

class RandomNumberGenerator : NumberGenerator {
    override fun generate(
        min: Int,
        max: Int,
    ): Int {
        return (min..max).random()
    }
}
