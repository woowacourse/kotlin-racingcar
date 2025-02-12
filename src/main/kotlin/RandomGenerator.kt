class RandomGenerator {
    private fun getRandomNumber(): Int = (0..9).random()

    fun getRandomAvailability(): Boolean = getRandomNumber() > 4
}
