package util

import domain.numbergenerator.NumberGenerator

class TestNumberGenerator(private val testNumber: Int) : NumberGenerator {
    override fun generate() = testNumber
}
