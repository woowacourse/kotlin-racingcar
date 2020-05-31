package randomutils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RandomGeneratorTest {
    @Test
    fun `랜덤 정수를 생성하는지 확인한다`() {
        val generatedValue = RandomGenerator.generateRandom()
        assertThat(generatedValue).isNotNull()
    }
}