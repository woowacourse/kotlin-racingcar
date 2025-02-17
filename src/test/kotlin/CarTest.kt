import domain.cars.Car
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `숫자가 4 이상이면 전진한다 `(number: Int) {
        // given
        val car = Car("포비")
        val expected = 1

        // when
        car.moveOrStop(number)

        // then
        Assertions.assertThat(car.distance).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `숫자가 4 미만이면 전진하지 않는다`(number: Int) {
        val car = Car("포비")
        val expected = 0

        car.moveOrStop(number)

        Assertions.assertThat(car.distance).isEqualTo(expected)
    }

    @Test
    fun `숫자가 4 이상이면 전진하고 위치를 출력한다`() {
        val car = Car("포비")
        val expected = "포비 : -"
        val movableNumber = 4

        car.moveOrStop(movableNumber)

        Assertions.assertThat(car.toString()).isEqualTo(expected)
    }

    @Test
    fun `숫자가 4 미만이면 전진하지 않고 위치를 출력한다`() {
        val car = Car("포비")
        val expected = "포비 : "
        val stayNumber = 3

        car.moveOrStop(stayNumber)

        Assertions.assertThat(car.toString()).isEqualTo(expected)
    }
}
