package racingcar.model

object RandomNumberGenerator {
    private val randomNumber = 0..9

    fun generateRandomNumber(): Int = randomNumber.random()
}
