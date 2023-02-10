package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import util.TestCarFactory

internal class CarTest {

    @MethodSource("provideCar")
    @ParameterizedTest
    fun `move 함수가 제대로 동작하는지 테스트`(randNum: Int, expectedDistance: String) {
        // given
        val car = TestCarFactory.makeCar("세훈", randNum)
        // when
        car.move()
        // then
        assertThat(car.distance).isEqualTo(expectedDistance)
    }

    @ValueSource(strings = ["", "실패실패실패"])
    @ParameterizedTest
    fun `차 이름이 1~5 범위 밖인 경우`(carName: String) {
        // given
        // when
        val carException = kotlin.runCatching { TestCarFactory.makeCar(carName, 5) }.exceptionOrNull()
        // then
        assertThat(carException).isInstanceOf(Exception::class.java)
        assertThat(carException).hasMessage(Car.NAME_CONVENTION_ERROR_MESSAGE)
    }

    @ValueSource(strings = ["성", "공성공성공"])
    @ParameterizedTest
    fun `차 이름이 1~5 범위 안인 경우`(carName: String) {
        // when
        val car = TestCarFactory.makeCar(carName, 5)
        // then
        assertThat(car.carName).isEqualTo(carName)
    }

    companion object {
        @JvmStatic
        fun provideCar(): List<Arguments> = listOf(
            Arguments.of(1, ""),
            Arguments.of(5, "-"),
        )
    }
}
