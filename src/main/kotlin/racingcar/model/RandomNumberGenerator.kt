package racingcar.model

class RandomNumberGenerator {
    fun generateRandomNumber(): Int = randomNumber.random()
    companion object{
        val randomNumber = 0..9
    }
}
