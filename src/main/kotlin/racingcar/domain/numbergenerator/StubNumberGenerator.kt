package racingcar.domain.numbergenerator

class StubNumberGenerator(
    private val fakeNumbers: MutableList<Int>,
) : NumberGenerator {
    override fun generate(): Int = fakeNumbers.removeAt(0)
}
