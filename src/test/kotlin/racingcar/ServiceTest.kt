package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.service.RandomGenerator

class ServiceTest {

    /** RandomGenerator Test */
    @Test
    fun `생성한 랜덤값의 범위가 1부터 9인지 확인한다`() {
        val randomGenerator = RandomGenerator()
        assertThat(randomGenerator.generate())
            .isGreaterThanOrEqualTo(1)
            .isLessThanOrEqualTo(9)
    }
    
}
