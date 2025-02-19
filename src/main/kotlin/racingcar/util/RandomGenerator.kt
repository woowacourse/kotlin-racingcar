package racingcar.util

class RandomGenerator {
    fun getRandomConditions(count: Int): List<Int> = List<Int>(count) { getRandomCondition() }

    private fun getRandomCondition(): Int = (MIN_RANDOM_CONDITION..MAX_RANDOM_CONDITION).random()

    companion object {
        private const val MIN_RANDOM_CONDITION = 0
        private const val MAX_RANDOM_CONDITION = 9
    }
}
