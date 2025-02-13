package racingcar

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.enums.Move
import racingcar.model.Car

class CarTest {
    private lateinit var car: Car

    @BeforeEach
    fun setUp() {
        car = Car("James")
    }

    @Test
    fun `전진이 가능하면 자동차의 위치가 1 증가한다`() {
        val moveState = Move.create(5)
        car.move(moveState)
        car.position.shouldBe(1)
    }

    @Test
    fun `전진이 가능하지 않으면 자동차의 위치가 유지된다`() {
        val moveState = Move.create(3)
        car.move(moveState)
        car.position.shouldBe(0)
    }
}
