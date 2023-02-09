package util

import domain.NumberGenerator

class TestNumberGenerator(private val testNumber: Int) : NumberGenerator {
    override fun generate() = testNumber
}
