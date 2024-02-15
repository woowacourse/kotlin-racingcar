package racingcar.controller

import org.junit.jupiter.api.BeforeEach

class RandomNumberGeneratorTest {
    private lateinit var randomNumberGenerator: RandomNumberGenerator

    @BeforeEach
    fun setup() {
        randomNumberGenerator = RandomNumberGenerator(3)
    }
}