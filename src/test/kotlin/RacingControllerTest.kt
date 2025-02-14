import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.RacingController
import racingcar.model.Car

class RacingControllerTest {
    private lateinit var racingController: RacingController

    @BeforeEach
    fun setUp() {
        racingController = RacingController()
    }

    @Test
    fun `자동차 이름을 입력하면 position이 0인 자동차 객체들이 리스트에 저장된다`() {
        val input = listOf("car1", "car2", "car3")

        val cars = racingController.generateCarList(input)

        assertThat(cars.map { it.position }).isEqualTo(listOf(0, 0, 0))
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
