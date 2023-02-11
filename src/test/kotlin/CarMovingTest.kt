import data.Car
import data.Car.Companion.INITIAL_POSITION
import domain.game.CarRacingGame
import domain.generator.NumberGenerator
import domain.generator.RacingNumberGenerator.Companion.MINIMUM_NUMBER
import domain.generator.RacingNumberGenerator.Companion.MINIMUM_NUMBER_TO_MOVE
import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CarMovingTest {

    private lateinit var carRacingGame: CarRacingGame

    @BeforeEach
    fun setUp() {
    }

    @Test
    private fun `정지 테스트 `() {
        val car = Car(
            name = "우기",
            racingNumberGenerator = object : NumberGenerator {
                override fun generate(): Int = MINIMUM_NUMBER
            }
        )

        car.move()
        assertThat(car.position).isEqualTo(INITIAL_POSITION)
    }

    @Test
    fun `전진 테스트`() {
        val car = Car(
            name = "우기",
            racingNumberGenerator = object : NumberGenerator {
                override fun generate(): Int = MINIMUM_NUMBER_TO_MOVE
            }
        )

        car.move()
        assertThat(car.position).isEqualTo(1)
    }
}
