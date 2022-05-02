package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class RandomsTest {

    @DisplayName("범위 내의 랜덤 숫자를 amount개 가져온다")
    @Test
    fun generateRandoms() {
        val randoms = Randoms(3)
        val moveFactors = randoms.generate()

        assertThat(moveFactors).hasSize(3)
    }

    @DisplayName("generate 시 입력한 파라미터 범위 내의 숫자를 발생한다.")
    @Test
    fun generateInRange() {
        val randoms = Randoms(3)
        val moveFactors = randoms.generate()
        assertAll(
            { assertThat(moveFactors[0]).isLessThan(10).isGreaterThanOrEqualTo(0) },
            { assertThat(moveFactors[1]).isLessThan(10).isGreaterThanOrEqualTo(0) },
            { assertThat(moveFactors[2]).isLessThan(10).isGreaterThanOrEqualTo(0) }
        )
    }
}
