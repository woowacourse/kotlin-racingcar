package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ParameterizedTest
    @ValueSource(strings = ["1", "22", "333", "4444", "55 5 "])
    fun `자동차 생성 테스트`(carName: String) {
        assertDoesNotThrow { Car(carName) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "33333", "44 4444"])
    fun `자동차 생성 예외 테스트`(carName: String) {
        assertThrows<IllegalArgumentException> { Car(carName) }
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `자동차 전진 테스트`(randomValue: Int) {
        val car = Car("carA")
        car.tryForward(randomValue)

        val output = car.getStep()
        val expected = "carA : -"

        assertThat(output).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `자동차 전진 실패 테스트`(randomValue: Int) {
        val car = Car("carA")
        car.tryForward(randomValue)

        val output = car.getStep()
        val expected = "carA : "

        assertThat(output).isEqualTo(expected)
    }
}
