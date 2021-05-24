package racingcar.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class RandomUtilTest {

    @DisplayName("0 ~ 9 사이의 랜덤 숫자를 생성한다")
    @Test
    internal fun `generate random number`() {
        // when
        val randomNumber = generateRandomNumber()

        // then
        assertThat(randomNumber).isBetween(0, 9)
    }
}
