import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ParameterizedTest
    @MethodSource("getMoveNumbers")
    fun `자동차가 이동을 시도하는 숫자가 4이상일 경우에 위치를 상승시키는 테스트`(
        tryNumbers: List<Int>,
        expect: Int,
    ) {
        val car = Car("동전")
        val numbersExtractor = NumbersExtractor(tryNumbers)
        repeat(numbersExtractor.currentNumbersSize) { car.move(numbersExtractor) }
        assertThat(expect).isEqualTo(car.position)
    }

    @ParameterizedTest
    @ValueSource(strings = ["abcdef", "익명123", "12345"])
    fun `자동차 이름 테스트`(name: String) {
        assertThrows<IllegalArgumentException> {
            Car(name)
        }
    }

    companion object {
        @JvmStatic
        fun getMoveNumbers(): List<Arguments> {
            return listOf(
                Arguments.arguments(listOf(1, 2, 3, 4, 5, 6), 3),
                Arguments.arguments(listOf(0, 2, 8, 9, 1), 2),
                Arguments.arguments(listOf(0, 19, 22, 33, 82, 1), 4),
            )
        }
    }
}
