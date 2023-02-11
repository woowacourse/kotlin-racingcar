import model.Car
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @Test
    fun `자동차 이름이 공백인 경우 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            Car("")
        }
    }

    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    @ParameterizedTest
    fun `4이상이면 자동차가 전진`(number: Int) {
        val car = Car("pobi")
        car.move(number)
        assertThat(car.position).isEqualTo(1)
    }

    @ValueSource(ints = [1, 2, 3])
    @ParameterizedTest
    fun `3이하이면 자동차가 정지`(number: Int) {
        val car = Car("pobi")
        car.move(number)
        assertThat(car.position).isEqualTo(0)
    }
}
