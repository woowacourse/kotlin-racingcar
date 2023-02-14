package racingcar.model

class RandomNumberTest(private val numbers: List<Int>) : NumberGenerator {
    private var index = 0
    override fun generate(): Int = numbers[index++]
}
