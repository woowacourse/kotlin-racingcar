import controller.GameController
import model.Car
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CarTest {
    private lateinit var car: Car
    private val gameController = GameController()

//    @BeforeEach
//    fun setUp() {
//        car = Car("car")
//    }
//
//    @Test
//    fun `무작위 값이 4 미만이면 자동차가 전진하지 않는다`() {
//        car.move(0)
//        assertThat(car.position).isEqualTo(0)
//    }
//
//    @Test
//    fun `가장 많이 전진한 자동차를 우승자 리스트에 추가한다`() {
//        val cars = listOf(Car("car1"), Car("car2"), Car("car3"))
//
//        val winner = gameController.getWinner(cars)
//
//        assertThat(winner).isEqualTo(listOf("car3"))
//    }
//
//    @Test
//    fun `가장 많이 전진한 자동차가 여러 대일 경우 모두 우승자 리스트에 추가한다`() {
//        val cars = listOf(Car("car1"), Car("car2"), Car("car3"))
//
//        val winner = gameController.getWinner(cars)
//
//        assertThat(winner).isEqualTo(listOf("car2", "car3"))
//    }
}
