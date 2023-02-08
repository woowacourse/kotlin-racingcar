class RacingNumberGenerator: RandomNumberGenerator {

    override fun generate(): Int {
        return (0..9).random()
    }
}
