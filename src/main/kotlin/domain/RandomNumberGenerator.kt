package domain

class RandomNumberGenerator : CarNumberGenerator {
    override fun generate() = (RANDOM_MIN_NUMBER..RANDOM_MAX_NUMBER).random()

    companion object {
        private const val RANDOM_MIN_NUMBER = 0
        private const val RANDOM_MAX_NUMBER = 9
    }
}
