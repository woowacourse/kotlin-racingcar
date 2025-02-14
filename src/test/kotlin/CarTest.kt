import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @Test
    fun `자동차 이동 가능 테스트`() {
        val car = Car("123")
        car.move(TryMoveNumber())
        val actual = 1
        assertThat(actual).isEqualTo(car.position)
    }

    @Test
    fun `자동차 이동 불가 테스트`() {
        val car = Car("123")
        car.move(TryStopNumber())
        val actual = 0
        assertThat(actual).isEqualTo(car.position)
    }

    @ParameterizedTest
    @ValueSource(strings = ["abcdef", "익명123", "12345"])
    fun `자동차 이름 테스트`(name: String) {
        assertThrows<IllegalArgumentException> {
            Car(name)
        }
    }
}
