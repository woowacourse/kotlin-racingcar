package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class MoveStrategyUsingNumberTest {
    private lateinit var car: Car
    private lateinit var moveStrategyUsingNumber: MoveStrategyUsingNumber

    @BeforeEach
    fun setUp() {
        car = Car("sh1m")
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `숫자가 4 이상, 9 이하일 때 전진한다`(number: Int) {
        moveStrategyUsingNumber = MoveStrategyUsingNumber(ExplicitNumberGenerator(number))
        moveStrategyUsingNumber.move(car)
        assertThat(car.position).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `숫자가 4 미만일 때는 멈춘다`(number: Int) {
        moveStrategyUsingNumber = MoveStrategyUsingNumber(ExplicitNumberGenerator(number))
        moveStrategyUsingNumber.move(car)
        assertThat(car.position).isEqualTo(0)
    }
}
