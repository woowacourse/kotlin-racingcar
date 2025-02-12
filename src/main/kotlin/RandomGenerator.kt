class RandomGenerator {
    private fun getRandomNumber(): Int = (MIN_RANDOM_NUMBER..MAX_RANDOM_NUMBER).random()

    fun getRandomAvailability(): Boolean = getRandomNumber() >= MIN_RANDOM_AVAILABILITY_CONDITION

    companion object {
        private const val MIN_RANDOM_NUMBER = 0
        private const val MAX_RANDOM_NUMBER = 9
        private const val MIN_RANDOM_AVAILABILITY_CONDITION = 4
    }
}
