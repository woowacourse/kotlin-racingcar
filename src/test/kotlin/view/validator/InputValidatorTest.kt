package view.validator

import org.assertj.core.api.Assertions.assertThatCode
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {

    @Nested
    inner class `validateCarNames 메소드는` {

        @Nested
        inner class `자동차 이름에 숫자가 포함되었다면` {
            private val carNames = "men2e,토마스"

            @Test
            fun `예외 메세지가 포함된 예외를 던진다`() {
                assertThatIllegalArgumentException().isThrownBy { InputValidator.validateCarNames(carNames) }
            }
        }

        @Nested
        inner class `자동차 이름의 길이가 1 이상 5 이하가 아니라면` {

            @ParameterizedTest
            @ValueSource(strings = ["mendel, hi", ", hi"])
            fun `예외 메세지가 포함된 예외를 던진다`(carNames: String) {
                assertThatIllegalArgumentException().isThrownBy { InputValidator.validateCarNames(carNames) }
            }
        }

        @Nested
        inner class `자동차 이름의 갯수가 2개 이상 20개 이하가 아니라면` {
            private val carNames = "hi"

            @Test
            fun `예외 메세지가 포함된 예외를 던진다`() {
                assertThatIllegalArgumentException().isThrownBy { InputValidator.validateCarNames(carNames) }
            }
        }

        @Nested
        inner class `자동차 이름이 중복되었다면` {
            private val carNames = "hi,hi"

            @Test
            fun `예외 메세지가 포함된 예외를 던진다`() {
                assertThatIllegalArgumentException().isThrownBy { InputValidator.validateCarNames(carNames) }
            }
        }

        @Nested
        inner class `모든 자동차 이름이 1~5글자이고 모든 문자가 한글 또는 영어라면` {
            val carNames = "wooah,토마스,멘델"

            @Test
            fun `예외를 던지지 않는다`() {
                assertThatCode { InputValidator.validateCarNames(carNames) }.doesNotThrowAnyException()
            }
        }
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
