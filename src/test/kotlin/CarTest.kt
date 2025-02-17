import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = [" ", "\t", "\n"])
    fun `자동차 이름이 공백일 때 에러를 발생시킨다`(name: String) {
        val exception = assertThrows<IllegalArgumentException> {
            Car(name)
        }

        assertTrue(exception.message?.contains("공백") ?: false)
    }

    @Test
    fun `자동차 이름의 길이가 5자를 초과할 때 에러를 발생시킨다`() {
        val name: String = "123456"
        assertThrows<IllegalArgumentException> {
            Car(name)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["공백", "뭉치", "딸기우유", "용"])
    fun `자동차 이름이 조건을 충족할 때, 자동차 객체를 생성한다`(name: String) {
        assertDoesNotThrow {
            Car(name)
        }
    }

    @Test
    fun `자동차의 초기 위치는 0이다`() {
        val car = Car("공백")
        val initialPosition = 0
        assertEquals(initialPosition, car.position)
    }

    @ParameterizedTest
    @CsvSource("9, true", "0, false")
    fun `전진 가능 여부에 따라 자동차는 전진하거나 멈춘다`(randomNumber: Int, isMoved: Boolean) {
        val car = Car("뭉치")
        val previousPosition = car.position

        car.moveForward(randomNumber)

        assertEquals(isMoved, car.position > previousPosition)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `랜덤 숫자가 4 미만인 경우 자동차는 멈춘다`(randomNumber: Int) {
        val car = Car("공백")
        val previousPosition = car.position

        car.moveForward(randomNumber)

        assertTrue(car.position == previousPosition)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `랜덤 숫자가 4 이상인 경우 자동차는 앞으로 이동한다`(randomNumber: Int) {
        val car = Car("공백")
        val previousPosition = car.position

        car.moveForward(randomNumber)

        assertTrue(car.position > previousPosition)
    }
}
