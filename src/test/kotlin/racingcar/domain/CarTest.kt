package racingcar.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @Test
    internal fun move() {
        val car = Car(object : MoveStrategy {
            override fun isMovable(): Boolean {
                return true
            }
        })
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

        val exception = assertThrows<java.lang.IllegalArgumentException> { Car(name = input) }
        assertThat(exception.message).isEqualTo("이름은 1 ~ 5 사이의 길이여야합니다.")
    }
}