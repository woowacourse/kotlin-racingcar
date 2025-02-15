package domain.numbergenerator

class TestNumberGenerator(private val numbers: MutableList<Int>) : NumberGenerator {
    override fun generate(): Int {
        return numbers.removeFirst()
    }
}
