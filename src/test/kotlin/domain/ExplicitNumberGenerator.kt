package domain

class ExplicitNumberGenerator(private val input: Int) : NumberGenerator {
    override fun generate() = input
}
