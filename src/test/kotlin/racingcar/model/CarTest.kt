package racingcar.model

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.lang.IllegalArgumentException

internal class CarTest {

    @DisplayName("자동차를 생성한다")
    @Test
    internal fun `create car`() {
        assertThatCode { Car("Benz") }.doesNotThrowAnyException()
    }

    @DisplayName("move pivot 보다 condition이 작으면 정지한다")
    @Test
    internal fun `stop car when condition less than move pivot`() {
        // given
        val car = Car("Benz")

        // when
        val stoppedCar = car.move(object : MoveStrategy {
            override fun move(): Boolean {
                return false
            }
        })

        // then
        assertThat(stoppedCar.position).isEqualTo(0)
    }

    @DisplayName("move pivot 보다 condition이 크거나 같으면 정지한다")
    @Test
    internal fun `move car when condition more than move pivot`() {
        // given
        val car = Car("Benz")

        // when
        val movedCar = car.move(object : MoveStrategy {
            override fun move(): Boolean {
                return true
            }
        })

        // then
        assertThat(movedCar.position).isEqualTo(1)
    }

    @DisplayName("자동차의 이름이 5글자를 초과하면 예외를 발생한다")
    @Test
    internal fun `car name length over than max car name length`() {
        // given
        val name = "Hyundai"

        // when //then
        assertThrows<IllegalArgumentException> { Car(name) }
    }

    @DisplayName("Position이 같은지 확인한다")
    @ParameterizedTest
    @CsvSource(value = ["3:3:true", "2:1:false"], delimiter = ':')
    internal fun `isSamePosition`(position: Int, targetPosition: Int, expected: Boolean) {
        // given
        val car = Car(name = "BENZ", position = position)

        // when
        val actual = car.isSamePosition(targetPosition)

        // then
        assertThat(actual).isEqualTo(expected)
    }
}
