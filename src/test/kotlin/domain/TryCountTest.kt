package domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class TryCountTest {
    @ParameterizedTest
    @ValueSource(strings = ["한글", "english"])
    fun `정수가 아닌 입력으로 TryCount 생성 시 예외를 던진다`(input: String) {
        assertThatThrownBy { TryCount.from(input) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("시도 횟수는 정수여야 합니다")
    }

    @ParameterizedTest
    @ValueSource(strings = ["-2", "0"])
    fun `0 이하인 수 입력 TryCount 생성 시 예외를 던진다`(input: String) {
        assertThatThrownBy { TryCount.from(input) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("시도 횟수는 0보다 큰 수여야 합니다")
    }

    @ParameterizedTest
    @CsvSource("1, 1", "2, 2", "3, 3")
    fun `1 이상인 수 입력 TryCount 생성 시 성공`(
        input: String,
        expectedCount: Int,
    ) {
        val tryCount = assertDoesNotThrow { TryCount.from(input) }
        assertThat(tryCount.count == expectedCount)
    }
}
