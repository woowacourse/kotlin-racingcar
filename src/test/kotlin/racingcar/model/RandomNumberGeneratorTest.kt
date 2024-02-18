package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.RepeatedTest

class RandomNumberGeneratorTest {
    @RepeatedTest(100)
    fun `랜덤넘버 리스트의 요소가 전부 제한 범위 내인지`() {
        val result = RandomNumberGenerator.generateRandomNumber()
        assertThat(result).isIn(0..9)
    }
}
