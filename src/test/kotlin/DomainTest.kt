import model.Car
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import service.RacingCarGameService

class DomainTest {
    private val racingCarGameService = RacingCarGameService()

    @DisplayName("차의 현재 상태를 잘 출력하는지 확인하는 테스트")
    @ParameterizedTest
    @CsvSource("aa,3,aa : ---", "bb,2,bb : --")
    fun testCarPresentStatus(name: String, position: Int, expected: String) {
        val actual = Car(name, position).getPresentStatus()
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `가장 멀리간 자동차를 확인하는 테스트`() {
        val carA = Car("aa", 1)
        val carB = Car("bb", 3)
        val carC = Car("cc", 2)

        val cars = listOf(carA, carB, carC)
        val actual = racingCarGameService.getMaxPositionCars(cars)
        assertThat(actual).isEqualTo(listOf(carB))
    }

    @Test
    fun `우승한 자동차를 정상적으로 출력하는지 테스트`() {
        val carA = Car("aa", 1)
        val carB = Car("bb", 3)
        val carC = Car("cc", 2)
        val carD = Car("dd", 3)

        val cars = listOf(carA, carB, carC, carD)
        val actual = racingCarGameService.getWinners(racingCarGameService.getMaxPositionCars(cars))
        assertThat(actual).isEqualTo("최종 우승자: bb, dd")
    }
}
