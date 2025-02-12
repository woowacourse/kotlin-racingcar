import kotlin.random.Random

class RandomNumberGenerator: NumberGenerator {
    override fun generate(): Int {
        return Random.nextInt(Constants.RANDOM_NUMBER_LOWER_BOUND, Constants.RANDOM_NUMBER_UPPER_BOUND)
    }

}