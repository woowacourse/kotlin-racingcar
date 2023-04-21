package racingcar.domain

class TestNumberGenerator(
    private val numbers: MutableList<Int>,
) : NumberGenerator {

    override fun generate(): Int {
        return numbers.removeAt(0)
    }
}
