package racingcar.model

class RandomNumberGenerator {
    fun make() = (MINIMUM_OF_MOVE_CONDITION..MAXIMUM_OF_MOVE_CONDITION).random()

    companion object {
        private const val MINIMUM_OF_MOVE_CONDITION = 0
        private const val MAXIMUM_OF_MOVE_CONDITION = 9
    }
}
