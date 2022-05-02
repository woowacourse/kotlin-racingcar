package racingcar.domain

import io.kotest.matchers.throwable.shouldHaveMessage
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class CarTest {

    @Test
    fun nameOverFiveLength() {
        assertThatThrownBy { Car("123456") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("이름은 5글자를 초과할 수 없습니다.")
    }

    @Test
    fun nameIsBlank() {
        assertThrows<IllegalArgumentException> {
            Car("   ")
        }.shouldHaveMessage("공백을 입력하면 안됩니다.")
    }

    @Test
    fun goOrNot() {
        val car = Car("123")
        val fixedMoveStrategy = FixedMoveStrategy(listOf(4, 4, 4, 1, 1))
        car.goOrNot(fixedMoveStrategy)
        car.goOrNot(fixedMoveStrategy)
        car.goOrNot(fixedMoveStrategy)
        car.goOrNot(fixedMoveStrategy)
        car.goOrNot(fixedMoveStrategy)

        assertThat(car.position).isEqualTo(3)
    }

    @Test
    fun isSamePosition() {
        val fixedMoveStrategy = FixedMoveStrategy(listOf(4, 4, 6, 6))

        val car1 = Car("test")
        car1.goOrNot(fixedMoveStrategy)
        car1.goOrNot(fixedMoveStrategy)

        val car2 = Car("test")
        car2.goOrNot(fixedMoveStrategy)
        car2.goOrNot(fixedMoveStrategy)

        assertThat(car1.isSamePosition(car2)).isTrue
    }
}
