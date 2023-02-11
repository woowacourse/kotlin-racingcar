import data.Car
import domain.game.CarRacingGame
import domain.generator.NumberGenerator
import domain.generator.RacingNumberGenerator
import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class WinnerTest {

    private lateinit var cars: List<Car>

    @BeforeEach
    fun setUp() {
        cars = listOf(
            Car(
                name = "우기",
                racingNumberGenerator = object : NumberGenerator {
                    override fun generate(): Int = RacingNumberGenerator.MINIMUM_NUMBER_TO_MOVE
                }
            ),
            Car(
                name = "부나",
                racingNumberGenerator = object : NumberGenerator {
                    override fun generate(): Int = RacingNumberGenerator.MINIMUM_NUMBER
                }
            ),
            Car(
                name = "핑구",
                racingNumberGenerator = object : NumberGenerator {
                    override fun generate(): Int = RacingNumberGenerator.MINIMUM_NUMBER_TO_MOVE
                }
            )
        )
    }

    @Test
    fun `우승자가 한명인 경우`() {
        val carRacingGame = CarRacingGame()
        carRacingGame.moveCars(cars.subList(0, 2))

        assertThat(
            carRacingGame.decideWinner(cars.subList(0, 2))
        ).isEqualTo(listOf("우기"))
    }

    @Test
    fun `우승자가 여러명인 경우`() {
        val carRacingGame = CarRacingGame()
        carRacingGame.moveCars(cars)

        assertThat(
            carRacingGame.decideWinner(cars)
        ).isEqualTo(listOf("우기", "핑구"))
    }
}
