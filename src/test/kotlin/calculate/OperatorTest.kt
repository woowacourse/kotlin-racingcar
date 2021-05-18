package calculate

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("연산자 테스트")
internal class OperatorTest {

    @DisplayName("덧셈 기능 테스트")
    @Test
    internal fun `add test`() {
        //given
        val a = Number("1")
        val b = Number("2")
        val additionOperator = Operator.ADDITION

        //when
        val actual = additionOperator.execute(a, b)

        //then
        assertThat(actual).isEqualTo(Number(3))
    }

    @DisplayName("뺄셈 기능 테스트")
    @Test
    internal fun `subtract test`() {
        //given
        val a = Number(2)
        val b = Number(1)
        val subtractionOperator = Operator.SUBTRACTION

        //when
        val actual = subtractionOperator.execute(a, b)

        //then
        assertThat(actual).isEqualTo(Number(1))
    }

    @DisplayName("곱셈 기능 테스트")
    @Test
    internal fun `multiply test`() {
        //given
        val a = Number(3)
        val b = Number(4)
        val multiplicationOperator = Operator.MULTIPLICATION

        //when
        val actual = multiplicationOperator.execute(a, b)

        //then
        assertThat(actual).isEqualTo(Number(12))
    }

}
