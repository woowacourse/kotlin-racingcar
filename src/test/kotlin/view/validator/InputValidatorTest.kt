package view.validator

import org.assertj.core.api.Assertions.assertThatCode
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {

    @Test
    fun `자동차 이름 입력 성공 테스트`() {
        assertThatCode {
            InputValidator.validateCarNames("wooah,토마스,멘델")
        }.doesNotThrowAnyException()
    }

    @ParameterizedTest
    @ValueSource(strings = ["men2e,토마스", "mendel,hi", "hi"])
    fun `자동차 이름 입력 실패 테스트`(names: String) {
        assertThatIllegalArgumentException().isThrownBy { InputValidator.validateCarNames(names) }
    }

    @Nested
    inner class `validateAdvanceCount 메소드는` {

        @Nested
        inner class `전진 횟수에 숫자가 아닌 값이 포함되면` {
            private val count = "123a"

            @Test
            fun `예외 메세지가 포함된 예외를 던진다`() {
                assertThatIllegalArgumentException().isThrownBy { InputValidator.validateAdvanceCount(count) }
                    .withMessageContaining(ERROR_MESSAGE)
            }
        }

        @Nested
        inner class `전진 횟수가 1 이상 100 이하의 숫자가 아니면` {

            @ParameterizedTest
            @ValueSource(strings = ["0", "101", "1239846128734691273647123481972736481972364912"])
            fun `예외 메세지가 포함된 예외를 던진다`(count: String) {
                assertThatIllegalArgumentException().isThrownBy { InputValidator.validateAdvanceCount(count) }
                    .withMessageContaining(ERROR_MESSAGE)
            }
        }

        @Nested
        inner class `전진 횟수가 1 이상 100 이하의 숫자라면` {
            private val count = "12"

            @Test
            fun `예외를 던지지 않는다`() {
                assertThatCode { InputValidator.validateAdvanceCount(count) }.doesNotThrowAnyException()
            }
        }
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}
