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
    @ValueSource(strings = ["", "123456", "ㄱㄴㄷㄹㅁㅂㅅ"])
    fun `자동차 이름의 길이가 0자 이거나 5자 초과할 때 에러를 발생시킨다`(name: String) {
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

    @Test
    fun `전진이 가능하면 자동차는 전진한다`() {
        val car = Car("뭉치")
        val isMoved = true
        val previousPosition = car.position

        car.moveForward(isMoved)

        Assertions.assertTrue(car.position > previousPosition)
    }

    @Test
    fun `전진이 불가능하면 자동차는 멈춘다`() {
        val car = Car("뭉치")
        val isMoved = false
        val previousPosition = car.position

        car.moveForward(isMoved)

        Assertions.assertTrue(car.position == previousPosition)
    }
}
