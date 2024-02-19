package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    private lateinit var car: Car

    @BeforeEach
    fun setup() {
        car = Car("A")
    }

    @ParameterizedTest
    @ValueSource(ints = [8, 5, 6, 9])
    fun `랜덤변수가 이동조건에 해당하면 true를 반환하는지`(input: Int) {
        val result = car.decideMovement(input)
        assertThat(result).isTrue()
    }

    @Test
    fun `랜덤변수가 이동조건에 해당하면 이동하는지`() {
        car.moveCar(7)
        assertThat(car.position == "-------")
    }
}