package racingcar.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.RepeatedTest

class RandomNumberGeneratorTest {
    private lateinit var randomNumberGenerator: RandomNumberGenerator

    @BeforeEach
    fun setup() {
        randomNumberGenerator = RandomNumberGenerator()
    }

    @RepeatedTest(100)
    fun `랜덤넘버 리스트의 요소가 전부 0 ~ 9 인지`() {
        val result = randomNumberGenerator.generateRandomNumber()
        assertThat(result).isIn(0..9)
    }
}
