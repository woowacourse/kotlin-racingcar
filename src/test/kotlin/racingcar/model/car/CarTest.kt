package racingcar.model.car

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    private lateinit var car: Car

    @BeforeEach
    fun setUp() {
        car = Car("buna")
    }

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

    // @ParameterizedTest
    // @ValueSource(ints = [4, 5, 6, 7, 8, 9, 10])
    // fun `4이상 10이하일 때, Car의 move 호출시, position이 증가한다`(condition: Int) {
    //     car.move(condition)
    //
    //     assertEquals(ONE_STEP, car.position)
    // }
    //
    // @ParameterizedTest
    // @ValueSource(ints = [1, 2, 3])
    // fun `4미만일 때, Car의 move 호출시, position이 증가하지 않는다`(condition: Int) {
    //     car.move(condition)
    //     assertNotEquals(ONE_STEP, car.position)
    // }

    companion object {
        private const val ONE_STEP = 1
    }
}
