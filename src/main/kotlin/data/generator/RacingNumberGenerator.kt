package data.generator

class RacingNumberGenerator : NumberGenerator {

    override fun generate(): Int {
        return NUMBER_RANGE.random()
    }

    companion object {
        private val NUMBER_RANGE = 0..9
    }
}
