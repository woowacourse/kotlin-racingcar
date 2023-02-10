import data.generator.NumberGenerator
import org.junit.jupiter.api.BeforeEach

class CarMovingTest {

    class MovingNumberGenerator : NumberGenerator {

        override fun generate(): Int {
            return (4..9).random()
        }
    }

    class StopNumberGenerator : NumberGenerator {

        override fun generate(): Int {
            return (0..3).random()
        }
    }

    private lateinit var stopNumberGenerator: StopNumberGenerator
    private lateinit var movingNumberGenerator: MovingNumberGenerator

    @BeforeEach
    fun setUp() {
        stopNumberGenerator = StopNumberGenerator()
        movingNumberGenerator = MovingNumberGenerator()
    }

    // @ParameterizedTest
    // @ValueSource(ints = [2, 3, 4, 5, 6, 7])
    // fun `정지 테스트 `(numberOfTry: Int) {
    //     val player = CarRacingGamePlayer(
    //         car = Car("우기"),
    //         numberOfTry = numberOfTry,
    //         numberGenerator = stopNumberGenerator
    //     )
    //
    //     assertThat(
    //         player.moveCar().path.count { pathState ->
    //             pathState == PathState.MOVE
    //         }
    //     ).isEqualTo(0)
    // }
    //
    // @ParameterizedTest
    // @ValueSource(ints = [2, 3, 4, 5, 6, 7])
    // fun `전진 테스트`(numberOfTry: Int) {
    //     val player = CarRacingGamePlayer(
    //         car = Car("우기"),
    //         numberOfTry = numberOfTry,
    //         numberGenerator = movingNumberGenerator
    //     )
    //
    //     assertThat(
    //         player.moveCar().path.count { pathState ->
    //             pathState == PathState.MOVE
    //         }
    //     ).isEqualTo(numberOfTry)
    // }
}
