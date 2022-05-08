package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun `+ 연산자를 이용해 좌, 우 값을 더한다`() {
        val calculator = Calculator()
        val result = calculator.calculate("1 + 2")

        result shouldBe 3
    }

    @Test
    fun `요구한 양식대로 들어오지 않으면 에러가 발생한다`() {
        val calculator = Calculator()
        shouldThrow<IllegalArgumentException> { calculator.calculate("1  +3") }
    }

    @Test
    fun `+, -, * 를 모두 수행한다`() {
        val calculator = Calculator()
        val result = calculator.calculate("1 + 3 - 1 * 3")
        result shouldBe 9
    }
}
