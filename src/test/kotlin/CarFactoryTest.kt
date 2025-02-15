import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class CarFactoryTest {
    @ParameterizedTest
    @MethodSource("getAnonymousCarSuccessCases")
    fun `자동차 익명 순서에 맞게 생성 성공 테스트`(
        carNames: List<String>,
        actual: List<Car>,
    ) {
        val carFactory = CarFactory()
        assertThat(actual).isEqualTo(carFactory.createCar(carNames))
    }

    @ParameterizedTest
    @MethodSource("getAnonymousCarFailCases")
    fun `자동차의 익명 순서에 맞게 생성 실패 테스트`(
        carsName: List<String>,
        actual: List<Car>,
    ) {
        val carFactory = CarFactory()
        assertFalse(actual == carFactory.createCar(carsName))
    }

    companion object {
        @JvmStatic
        fun getAnonymousCarSuccessCases(): List<Arguments> {
            return listOf(
                Arguments.arguments(listOf("", "  ", "    "), listOf(Car("익명1"), Car("익명2"), Car("익명3"))),
                Arguments.arguments(listOf("동전", "제리", ""), listOf(Car("동전"), Car("제리"), Car("익명1"))),
                Arguments.arguments(listOf("제리", "  ", "제이든"), listOf(Car("제리"), Car("익명1"), Car("제이든"))),
                Arguments.arguments(listOf("제이든", "", "제리", ""), listOf(Car("제이든"), Car("익명1"), Car("제리"), Car("익명2"))),
            )
        }

        @JvmStatic
        fun getAnonymousCarFailCases(): List<Arguments> {
            return listOf(
                Arguments.arguments(listOf("", "  ", "    "), listOf(Car("익명3"), Car("익명2"), Car("익명1"))),
                Arguments.arguments(listOf("동전", "제리", ""), listOf(Car("동전"), Car("제리"), Car("익명3"))),
                Arguments.arguments(listOf("제리", "  ", "제이든"), listOf(Car("제리"), Car("익명2"), Car("제이든"))),
                Arguments.arguments(listOf("제이든", "", "제리", ""), listOf(Car("익명1"), Car("익명2"), Car("제리"), Car("익명4"))),
            )
        }
    }
}
