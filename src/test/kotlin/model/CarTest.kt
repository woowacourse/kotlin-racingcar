package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ParameterizedTest
    @ValueSource(strings = ["1", "22", "333", "4444", "55 5 "])
    fun `자동차 이름 유효성 테스트`(carName: String) {
        assertDoesNotThrow { Car(carName) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "333333", "44 4444"])
    fun `자동차 이름 유효성 예외 테스트`(carName: String) {
        assertThrows<IllegalArgumentException> { Car(carName) }
    }

    @Test
    fun `자동차의 초기 위치는 0이어야 한다`() {
        val car = Car("car1")

        assertEquals(0, car.position)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `자동차는 4 이상의 값이 들어오면 한칸 전진한다`(randomValue: Int) {
        val car = Car("carA")
        car.tryForward(randomValue)

        val output = "-".repeat(car.position)
        val expected = "-"

        assertThat(output).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `자동차는 4 미만의 값이 들어오면 정지한다`(randomValue: Int) {
        val car = Car("carA")
        car.tryForward(randomValue)

        val output = "-".repeat(car.position)
        val expected = ""

        assertThat(output).isEqualTo(expected)
    }
}
