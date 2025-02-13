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

    @Test
    fun `가장 많이 전진한 자동차를 우승자 리스트에 추가한다`() {
        val cars = mutableListOf(Car("car1", 1), Car("car2", 2), Car("car3", 3))
        val winner = racingController.getWinner(cars)
        assertThat(winner).isEqualTo(mutableListOf("car3"))
    }

    @Test
    fun `가장 많이 전진한 자동차가 여러 대일 경우 모두 우승자 리스트에 추가한다`() {
        val cars = mutableListOf(Car("car1", 1), Car("car2", 2), Car("car3", 2))
        val winner = racingController.getWinner(cars)
        assertThat(winner).isEqualTo(mutableListOf("car2", "car3"))
    }
}
