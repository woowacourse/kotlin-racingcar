package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @Test
    internal fun move() {
        val moveStrategy: MoveStrategy = object : MoveStrategy {
            override fun isMovable(): Boolean {
                return true
            }

        }
        val car = Car(moveStrategy)
        car.move()
        assertThat(car.isSamePosition(1)).isTrue()
    }

    @Test
    internal fun create() {
        val car = Car(RandomMoveStrategy, "aaron")
        val car1 = Car(RandomMoveStrategy, "aaron")

        assertThat(car).isEqualTo(car1)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "abcdef"])
    internal fun validateName(input: String) {

        assertThatThrownBy { Car(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("이름은 1 ~ 5 사이의 길이여야합니다.")
    }
}