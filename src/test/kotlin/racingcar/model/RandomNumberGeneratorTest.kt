package racingcar.model

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
    fun `랜덤 숫자가 전진 범위 숫자인지`() {
        val result = randomNumberGenerator.make()

        assertThat(result).isBetween(0, 9)
    }
}
