import data.Car
import data.PathState
import data.generator.NumberGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarMovingTest {

    @Test
    fun `정지 테스트 `() {
        val car = Car("우기")
        val condition = object : NumberGenerator {
            override fun generate(): Int {
                return (0..3).random()
            }
        }.generate()
        assertThat(car.move(condition)).isEqualTo(PathState.STOP)
    }

    @Test
    fun `전진 테스트 `() {
        val car = Car("핑구")
        val condition = object : NumberGenerator {
            override fun generate(): Int {
                return (4..9).random()
            }
        }.generate()
        assertThat(car.move(condition)).isEqualTo(PathState.MOVE)
    }

    companion object {
        const val MOVE_NUMBER = 4
        const val STOP_NUMBER = 0
    }
}
