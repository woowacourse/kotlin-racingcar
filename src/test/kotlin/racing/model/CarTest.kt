package racing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CarTest {
    private val car = Car("woni")

    @Test
    fun `차 이름이 5글자가 넘으면 exception 발생`() {
        assertThrows<IllegalArgumentException> {
            Car("aaaaaa")
        }
    }

    @Test
    fun `차 이름이 빈칸이면 exception 발생`() {
        assertThrows<IllegalArgumentException> {
            Car("")
        }
    }

    @ParameterizedTest
    @CsvSource("4", "5", "6", "7", "8", "9")
    fun `랜덤 숫자가 4부터 9까지 사잇값이 나왔을 떄 이동`(randomNumber: Int) {
        car.move(randomNumber)
        assertThat(car.position).isEqualTo(1)
    }

    @ParameterizedTest
    @CsvSource("1", "2", "3")
    fun `랜덤 숫자가 1부터 3까지 사잇값이 나왔을 떄 이동하지않음`(randomNumber: Int) {
        car.move(randomNumber)
        assertThat(car.position).isEqualTo(0)
    }
}
