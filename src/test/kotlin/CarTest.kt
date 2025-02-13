import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = [4, 6, 8, 10, 21])
    fun `자동차 이동 테스트`(tryNumber: Int) {
        val car = Car("123")
        car.move(tryNumber)
        val actual = 1
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
