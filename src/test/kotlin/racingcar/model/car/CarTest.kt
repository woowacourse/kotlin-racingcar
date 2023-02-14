package racingcar.model.car

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.car.move.step.MoveStep
import racingcar.model.car.move.step.OneStep
import racingcar.model.car.move.step.ZeroStep

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

    @Test
    fun `OneStep이 주어지고, Car의 move 호출시, position이 1 증가한다`() {
        val step: MoveStep = OneStep

        car.move(step)

        assertEquals(step.move(), car.position)
    }

    @Test
    fun `ZeroStep이 주어지고, Car의 move 호출시, position이 증가하지 않는다`() {
        val step: MoveStep = ZeroStep

        car.move(step)

        assertEquals(step.move(), car.position)
    }
}
