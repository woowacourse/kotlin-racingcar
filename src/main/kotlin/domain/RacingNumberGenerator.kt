package domain

class RacingNumberGenerator : NumberGenerator {

    override fun generate(): Int {
        return (MINIMUM_NUMBER..MAXIMUM_NUMBER).random()
    }

    companion object {
        const val MINIMUM_NUMBER = 0
        const val MAXIMUM_NUMBER = 9
    }
}
