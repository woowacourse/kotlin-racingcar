package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.enums.MoveState
import racingcar.model.Car

class CarTest {
    private lateinit var car: Car

    @BeforeEach
    fun setUp() {
        car = Car("James")
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `값이 4 이상이면 자동차가 전진한다`(number: Int) {
        val moveState = MoveState.create(number)
        car.move(moveState)
        assertThat(car.position).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `값이 3 이하이면 자동차가 정지한다`(number: Int) {
        val moveState = MoveState.create(number)
        car.move(moveState)
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `자동차가 3번 전진하면 자동차의 위치는 3이다`() {
        repeat(3) { car.move(MoveState.MOVABLE) }
        assertThat(car.position).isEqualTo(3)
    }

    @Test
    fun `자동차가 전진하지 않으면 자동차의 위치는 0이다`() {
        val moveState = MoveState.create(3)
        car.move(moveState)
        assertThat(car.position).isEqualTo(0)
    }
}
