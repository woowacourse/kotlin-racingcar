package domain

class RandomNumberGenerator : NumberGenerator {
    override fun generate(): Int {
        return (RANDOM_LOWER_INCLUSIVE..RANDOM_UPPER_INCLUSIVE).random()
    }

    companion object {
        private const val RANDOM_LOWER_INCLUSIVE = 0
        private const val RANDOM_UPPER_INCLUSIVE = 9
    }
}
