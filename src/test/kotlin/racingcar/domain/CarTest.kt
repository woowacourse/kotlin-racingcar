package racingcar.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun 같은_위치_판별() {
        val car1 = Car("토르", 2)

        assertThat(car1.isSamePosition(Position(2))).isTrue()
    }

    @Test
    fun 자동차_전진() {
        val car = Car("토르, 0")

        car.moveForward(AlwaysMoveStrategy())

        assertThat(car.isSamePosition(Position(1))).isTrue()
    }
}
