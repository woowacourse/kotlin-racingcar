import domain.cars.Car
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `숫자가 4 이상이면 전진한다 `() {
        // given
        val car = Car("포비")
        val expected = 1

        // when
        car.updateDistanceIfMovable(4)

        // then
        Assertions.assertThat(car.getDistance()).isEqualTo(expected)
    }

    @Test
    fun `숫자가 4 미만이면 전진하지 않는다`() {
        val car = Car("포비")
        val expected = 0

        car.updateDistanceIfMovable(1)

        Assertions.assertThat(car.getDistance()).isEqualTo(expected)
    }
}
