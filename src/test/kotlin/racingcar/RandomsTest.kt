package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RandomsTest {

    @DisplayName("범위 내의 랜덤 숫자를 amount개 가져온다")
    @Test
    fun generateRandoms() {
        val randoms = Randoms(3)
        val moveFactors = randoms.generate(0, 10)
        assertThat(moveFactors).hasSize(3)
    }
}
