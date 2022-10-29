package racingcar.domain

import io.kotest.matchers.booleans.shouldBeTrue
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `같은 위치 판별`() {
        val car1 = Car("토르", 2)

        car1.isSamePosition(Position(2)).shouldBeTrue()
    }

    @Test
    fun 자동차_전진() {
        val car = Car("토르", 0)

        car.moveForward(AlwaysMoveStrategy())

        car.isSamePosition(Position(1)).shouldBeTrue()
    }
}
