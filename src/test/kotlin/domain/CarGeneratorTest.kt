package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import racingcar.domain.generator.anonymous.AnonymousNumbersExtractor
import racingcar.domain.generator.car.CarGenerator
import racingcar.domain.model.Car

class CarGeneratorTest {
    private lateinit var carGenerator: CarGenerator

    @BeforeEach
    fun setUp() {
        carGenerator = CarGenerator(AnonymousNumbersExtractor(listOf(1, 2, 3, 4, 5, 6)))
    }

    @ParameterizedTest
    @MethodSource("getAnonymousCarSuccessCases")
    fun `자동차 익명 순서에 맞게 생성 성공 테스트`(
        carNames: List<String>,
        actual: List<Car>,
    ) {
        assertThat(actual).isEqualTo(carGenerator.createCars(carNames))
    }

    @ParameterizedTest
    @MethodSource("getAnonymousCarFailCases")
    fun `자동차의 익명 순서에 맞게 생성 실패 테스트`(
        carsName: List<String>,
        actual: List<Car>,
    ) {
        assertFalse(actual == carGenerator.createCars(carsName))
    }

    companion object {
        @JvmStatic
        fun getAnonymousCarSuccessCases(): List<Arguments> {
            return listOf(
                Arguments.arguments(listOf("", "  ", "    "), listOf(Car("익명1"), Car("익명2"), Car("익명3"))),
                Arguments.arguments(listOf("동전", "제리", ""), listOf(Car("동전"), Car("제리"), Car("익명1"))),
                Arguments.arguments(listOf("제리", "  ", "제이든"), listOf(Car("제리"), Car("익명1"), Car("제이든"))),
                Arguments.arguments(listOf("제이든", "", "제리", ""), listOf(Car("제이든"), Car("익명1"), Car("제리"), Car("익명2"))),
                Arguments.arguments(listOf("익명3", "익명4", "  "), listOf(Car("익명3"), Car("익명4"), Car("익명1"))),
                Arguments.arguments(listOf("익명3", "익명1.0", "  "), listOf(Car("익명3"), Car("익명1.0"), Car("익명1"))),
                Arguments.arguments(listOf("익명3", "익명1.3", "  "), listOf(Car("익명3"), Car("익명1.3"), Car("익명1"))),
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
