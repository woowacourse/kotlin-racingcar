package racingcar.model

class RandomNumberGenerator(private val includeMinNum: Int, private val includeMaxNum: Int) : NumberGenerator {
    override fun getNumber() = (includeMinNum..includeMaxNum).random()
}
