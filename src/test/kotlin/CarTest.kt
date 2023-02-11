import domain.generator.CarGenerator
import domain.generator.NumberGenerator
import model.Car
import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class CarTest {

    private lateinit var carGenerator: CarGenerator

    @BeforeEach
    fun setUp() {
        carGenerator = CarGenerator()
    }

    @ParameterizedTest
    @MethodSource("generateValidCarName")
    fun `유효한 자동차 이름 확인하기`(carName: String) {
        assertDoesNotThrow {
            carGenerator.generateCars(
                listOf(
                    "제임스",
                    "우기",
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("generateInValidCarName")
    fun `유효하지 않은 자동차 이름 확인하기`(names: List<String>) {
        assertThrows<IllegalArgumentException> {
            carGenerator.generateCars(names)
        }
    }

    @Test
    private fun `정지 테스트 `() {
        val car = Car(
            name = "우기",
            racingNumberGenerator = object : NumberGenerator {
                override fun generate(): Int = MAXIMUM_NUMBER_TO_STOP
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

    private fun generateValidCarName(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(
                listOf("제임스", "부나x", "  ")
            ),
            Arguments.of(
                listOf("우기", "woogi")
            ),
        )
    }

    private fun generateInValidCarName(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(
                listOf("아우디", "안희애", "우아한테크코스")
            ),
            Arguments.of(
                listOf("배달의 민족", "곽두팔")
            ),
        )
    }

    companion object {
        private const val MAXIMUM_NUMBER_TO_STOP = 3
        private const val MINIMUM_NUMBER_TO_MOVE = 4

        private const val INITIAL_POSITION = 0
    }
}
