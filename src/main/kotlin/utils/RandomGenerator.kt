package utils

object RandomGenerator {
    fun generateRandomNumber(): Int {
        return (MIN_RANGE..MAX_RANGE).random()
    }

    private const val MIN_RANGE = 0
    private const val MAX_RANGE = 9
}
