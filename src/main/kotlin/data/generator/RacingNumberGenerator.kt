package data.generator

class RacingNumberGenerator : NumberGenerator {

    override fun generate(): Int {
        return (RANDOM_NUMBER_MIN..RANDOM_NUMBER_MAX).random()
    }

    companion object {
        const val RANDOM_NUMBER_MIN = 0
        const val RANDOM_NUMBER_MAX = 9
    }
}
