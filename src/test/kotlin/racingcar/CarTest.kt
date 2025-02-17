package racingcar

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.enums.MoveState
import racingcar.model.Car

class CarTest {
    private lateinit var car: Car

    @BeforeEach
    fun setUp() {
        car = Car("James")
    }

    @Test
    fun `4이상의 값이 전달되면 자동차의 위치가 1 증가한다`() {
        val moveState = MoveState.create(5)
        car.moveCarWhenMovable(moveState)
        car.position.shouldBe(1)
    }

    @Test
    fun `4 미만의 값이 전달되면 자동차의 위치가 유지된다`() {
        val moveState = MoveState.create(3)
        car.moveCarWhenMovable(moveState)
        car.position.shouldBe(0)
    }
}
