package data.generator

class RacingNumberGenerator : NumberGenerator {

    override fun generate(): Int {
        return (0..9).random()
    }
}
