import model.Car
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import service.RacingCarGameService

class RacingCarGameTest {
    private val racingCarGameService = RacingCarGameService()

    @Test
    fun `가장 멀리간 자동차를 확인한다`() {
        val carA = Car("aa", 1)
        val carB = Car("bb", 3)
        val carC = Car("cc", 2)

        val cars = listOf(carA, carB, carC)
        val actual = racingCarGameService.getMaxPositionCarNames(cars)
        assertThat(actual).isEqualTo(listOf(carB))
    }

    @Test
    fun `공동 우승한 자동차들을 확인한다`() {
        val carA = Car("aa", 1)
        val carB = Car("bb", 3)
        val carC = Car("cc", 2)
        val carD = Car("dd", 3)

        val cars = listOf(carA, carB, carC, carD)
        val actual = racingCarGameService.getMaxPositionCarNames(cars)
        assertThat(actual).isEqualTo(listOf(carB, carD))
    }
}
