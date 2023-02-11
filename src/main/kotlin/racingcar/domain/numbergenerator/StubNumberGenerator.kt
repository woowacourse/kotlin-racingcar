package racingcar.domain.numbergenerator

class StubNumberGenerator(
    private val fakeNumbers: List<Int>,
) : NumberGenerator {

    private val recivedFakeNumbers = fakeNumbers.toMutableList()
    override fun generate(): Int = recivedFakeNumbers.removeAt(0)
}
