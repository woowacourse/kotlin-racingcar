import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = [" ", "\t", "\n"])
    fun `자동차 이름이 공백일 때 에러를 발생시킨다`(name: String) {
        assertThrows<IllegalArgumentException> {
            Car(name)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["123456"])
    fun `자동차 이름의 길이가 5자를 초과할 때 에러를 발생시킨다`(name: String) {
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
        Assertions.assertEquals(initialPosition, car.position)
    }

    @ParameterizedTest
    @ValueSource(booleans = [true, false])
    fun `전진 가능 여부에 따라 자동차는 전진하거나 멈춘다`(isMoved: Boolean) {
        val car = Car("뭉치")
        val previousPosition = car.position

        car.moveForward(isMoved)

        Assertions.assertEquals(isMoved, car.position > previousPosition)
    }
}
