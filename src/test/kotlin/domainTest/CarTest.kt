package domainTest

import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CarTest : BaseForTest() {

    @ParameterizedTest
    @MethodSource("generateInValidCarName")
    fun `유효하지 않은 자동차 이름 확인하기`(names: List<String>) {
        assertThrows<IllegalArgumentException> {
            carGenerator.generateCars(names)
        }
    }

    @ParameterizedTest
    @MethodSource("generateValidCarName")
    fun `유효한 자동차 이름 확인하기`(names: List<String>) {
        assertDoesNotThrow {
            carGenerator.generateCars(names)
        }
    }

    @Test
    fun `정지 테스트 `() {
        stopCars.forEach { stopCar ->
            stopCar.move()
        }

        assertThat(
            stopCars.filter { stopCar ->
                stopCar.position == INITIAL_POSITION
            }
        ).isEqualTo(stopCars)
    }

    @Test
    fun `전진 테스트`() {
        movingCars.forEach { movingCar ->
            movingCar.move()
        }

        assertThat(
            movingCars.filter { movingCar ->
                movingCar.position == 1
            }
        ).isEqualTo(movingCars)
    }

    private fun generateInValidCarName(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(
                listOf("아우디", "안희애", "우아한테크코스")
            ),
            Arguments.of(
                listOf("배달의 민족", "곽두팔")
            ),
            Arguments.of(
                listOf("김진욱", "******", "      ")
            ),
        )
    }

    private fun generateValidCarName(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(
                listOf("제 임스", "우기", "스x캇")
            ),
            Arguments.of(
                listOf("김*욱", "안  기효")
            ),
        )
    }
}
