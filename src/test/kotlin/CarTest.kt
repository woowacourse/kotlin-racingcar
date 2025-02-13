import model.Car
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import util.Constants

class CarTest {
    private lateinit var car: Car
    private val racingController = RacingController()

    @BeforeEach
    fun setUp() {
        car = Car("car", 0)
    }

    @Test
    fun `무작위 값이 4 이상이면 자동차가 전진한다`() {
        val number = (Constants.CONDITION_RANDOM_MIN..Constants.CONDITION_RANDOM_MAX).random()

        racingController.moveCars(number, car)

        if (number >= Constants.CONDITION_MOVE_THRESHOLD) {
            assertThat(car.position).isEqualTo(1)
        } else {
            assertThat(car.position).isEqualTo(0)
        }
    }
}
