import domain.generator.CarGenerator
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CarGeneratingTest {
    private lateinit var carGenerator: CarGenerator

    @BeforeEach
    fun setUp() {
        carGenerator = CarGenerator()
    }

    @ParameterizedTest
    @MethodSource("generateInValidCarName")
    fun `유효하지 않은 자동차 이름 확인하기`(names: List<String>) {
        assertThrows<IllegalArgumentException> {
            carGenerator.generateCars(names)
        }
    }

    private fun generateInValidCarName(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(
                listOf("아우디", "안희애", "우아한테크코스")
            ),
            Arguments.of(
                listOf("우기", "우아한형제들")
            ),
            Arguments.of(
                listOf("배달의 민족", "곽두팔")
            ),
        )
    }
}
