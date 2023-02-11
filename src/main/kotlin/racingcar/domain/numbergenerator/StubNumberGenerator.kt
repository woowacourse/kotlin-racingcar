package racingcar.domain.numbergenerator

class StubNumberGenerator(
    private val fakeNumbers: List<Int>,
) : NumberGenerator {
    override fun generate(): Int = fakeNumbers.toMutableList().removeAt(0)
}
