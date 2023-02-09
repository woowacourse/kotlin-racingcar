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
    fun `차 주행 테스트`(randNum: Int, expectedDistance: String) {
        val car = TestCarFactory.makeCar("세훈", randNum)

        car.decideCarMovement()

        assertThat(car.distance).isEqualTo(expectedDistance)
    }

    @ValueSource(strings = ["", "실패실패실패", "성", "공성공성공"])
    @ParameterizedTest
    fun `차 이름 유효성 확인 테스트`(carName: String) {
        var car = TestCarFactory.makeCar("temp", 5)

        val carException = kotlin.runCatching { car = TestCarFactory.makeCar(carName, 5) }.exceptionOrNull()

        when (carException == null) {
            true -> testSuccessCase(car, carName)
            false -> testFailCase(carException)
        }
    }

    private fun testFailCase(carException: Throwable) {
        assertThat(carException).isInstanceOf(Exception::class.java)
        assertThat(carException).hasMessage(Car.NAME_CONVENTION_ERROR_MESSAGE)
    }

    private fun testSuccessCase(car: Car, expectedCarName: String) {
        assertThat(car.carName).isEqualTo(expectedCarName)
    }

    companion object {
        @JvmStatic
        fun provideCar(): List<Arguments> = listOf(
            Arguments.of(1, ""),
            Arguments.of(5, "-"),
        )
    }
}
