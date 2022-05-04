package calculator

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StringCalculatorTest {

    @DisplayName("숫자를 ,로 구분하면 숫자를 나눈다")
    @Test
    fun split() {
        val stringCalculator = StringCalculator.split("1,2,3")
        val numbers = stringCalculator.numbers

        assertSoftly(numbers) {
            shouldHaveSize(3)
            shouldContain(1)
            shouldContain(2)
            shouldContain(3)
        }
    }

    @DisplayName("음수를 넣으면 에러가 발생한다.")
    @Test
    fun splitNegativeException() {
        shouldThrow<IllegalArgumentException> {
            StringCalculator.split("-1,2,3")
        }.shouldHaveMessage("[ERROR] 숫자는 양수여야 합니다.")
    }

    @DisplayName("커스텀 구분자를 넣어 숫자를 나눌 수 있다")
    @Test
    fun splitCustomDelimiter() {
        val stringCalculator = StringCalculator.split("//;\n1;2;3")
        val numbers = stringCalculator.numbers

        assertSoftly(numbers) {
            shouldHaveSize(3)
            shouldContain(1)
            shouldContain(2)
            shouldContain(3)
        }
    }

    @DisplayName("숫자를 입력하지 않을 시 에러를 발생한다.")
    @Test
    fun splitNotNumberException() {
        assertThrows<IllegalArgumentException> {
            StringCalculator.split("r,2,3")
        }.shouldHaveMessage("[ERROR] 숫자를 입력하세요")
    }

    @DisplayName("값을 더한다.")
    @Test
    fun sum() {
        val result = StringCalculator.split("1,2,3").sum()
        result shouldBe 6
    }
}
