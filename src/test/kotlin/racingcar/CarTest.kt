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
    fun `자동차가 1번 전진하면 자동차의 위치는 1이다`() {
        val moveState = MoveState.create(5)
        car.move(moveState)
        car.position.shouldBe(1)
    }

    @Test
    fun `자동차가 전진하지 않으면 자동차의 위치는 0이다`() {
        val moveState = MoveState.create(3)
        car.move(moveState)
        car.position.shouldBe(0)
    }
}
