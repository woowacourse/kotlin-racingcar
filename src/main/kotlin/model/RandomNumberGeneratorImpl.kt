package model

class RandomNumberGeneratorImpl : RandomNumberGenerator {
    override fun generate(): Int = (MIN_RANGE..MAX_RANGE).random()

    private companion object {
        const val MIN_RANGE: Int = 0
        const val MAX_RANGE: Int = 9
    }
}
