package racingcar.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = ["buna", "otter", "jack", "son"])
    fun `1글자 이상 5글자 이하의 이름이 주어졌을 때, 자동차 객체 생성시, 예외가 발생하지 않는다`(name: String) {
        assertDoesNotThrow {
            Car(name)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["refactoring", "reviewer", "", "jackson"])
    fun `공백이나 5글자 이상의 이름이 주어졌을 때, 자동차 생성시, IllegalArgumentException 예외가 발생한다`(name: String) {
        assertThrows<IllegalArgumentException> {
            Car(name)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 5, 10])
    fun `movement가 주어졌을 때, 자동차를 movement만큼 이동시, 자동차가 position 만큼 이동한다`(movement: Int) {
        val car = Car("otter")
        repeat(movement) {
            car.move(ABSOLUTE_MOVE_CONDITION)
        }

        assertEquals(movement, car.position)
    }

    companion object {
        private const val ABSOLUTE_MOVE_CONDITION = 10
    }
}
