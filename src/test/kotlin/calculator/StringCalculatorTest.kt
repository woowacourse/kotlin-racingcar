package calculator

import io.kotest.matchers.throwable.haveMessage
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

class StringCalculatorTest {

    @DisplayName("숫자를 ,로 구분하면 숫자를 나눈다")
    @Test
    fun split() {
        val stringCalculator = StringCalculator.split("1,2,3")
        assertAll(
            { assertThat(stringCalculator.numbers).hasSize(3) },
            { assertThat(stringCalculator.numbers).contains(1) },
            { assertThat(stringCalculator.numbers).contains(2) },
            { assertThat(stringCalculator.numbers).contains(3) }
        )
    }

    @DisplayName("음수를 넣으면 에러가 발생한다.")
    @Test
    fun splitNegativeException() {
        assertThrows<IllegalArgumentException> {
            StringCalculator.split("-1,2,3")
            haveMessage("[ERROR] 숫자는 양수여야 합니다.")
        }
    }
}
