import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.Car

class CarTest {
    private lateinit var car: Car

    @BeforeEach
    fun setUp() {
        car = Car("car", 0)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6])
    fun `자동차는 4 이상의 값이 들어오면 한칸 전진한다`(number: Int) {
        car.move(number)
        assertThat(car.position).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 2, 3])
    fun `자동차는 4 미만의 값이 들어오면 전진하지 않는다`(number: Int) {
        car.move(number)

        assertThat(car.position).isEqualTo(0)
    }
}
