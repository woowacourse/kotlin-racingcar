package racingcar.domain

class GenerateRandomNumber {
    fun randomNumber() = (MIN_BOUND..MAX_BOUND).random()

    companion object {
        const val MIN_BOUND = 0
        const val MAX_BOUND = 9
    }
}
