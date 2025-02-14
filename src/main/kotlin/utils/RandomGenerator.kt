package utils

object RandomGenerator {
    fun getRandomNumber(
        start: Int,
        end: Int,
    ): Int {
        return (start..end).random()
    }
}
