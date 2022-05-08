package calculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class OperatorTest {

    @Test
    fun `+를 찾는다`() {
        val operator = Operator.of("+")

        operator shouldBe Operator.PLUS
    }

    @Test
    fun `- 연산한다`() {
        val result = Operator.of("-").calculate(1, 2)

        result shouldBe -1
    }

    @Test
    fun `* 연산한다`() {
        val result = Operator.of("*").calculate(1, 2)

        result shouldBe 2
    }

    @Test
    fun `나누기 연산한다`() {
        val result = Operator.of("/").calculate(2, 1)

        result shouldBe 2
    }
}
