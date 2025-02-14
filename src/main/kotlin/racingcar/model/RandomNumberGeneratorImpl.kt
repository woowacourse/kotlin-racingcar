package racingcar.model

class RandomNumberGeneratorImpl : RandomNumberGenerator {
    override fun generate(
        min: Int,
        max: Int,
    ): Int {
        return (min..max).random()
    }
}
