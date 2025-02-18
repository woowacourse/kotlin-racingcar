package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RoundResultTest {
    private val redCar = Car("red", 1)
    private val blueCar = Car("blue", 2)
    private val greenCar = Car("green", 3)

    private val cars: List<Car> = listOf(redCar, blueCar, greenCar)
    private val roundResult = RoundResult(cars)

    private val correctResult: List<String> = listOf("red : -", "blue : --", "green : ---")

    @Test
    fun `자동차 이름과 현재 위치를 문자열로 변환하여 반환한다`() {
        val nameAndPosition: List<String> = roundResult.getRoundResult()

        assertThat(nameAndPosition).isEqualTo(correctResult)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `랜덤 값이 4 이상이면 true 를 반환한다`(input: Int) {
        assertThat(roundResult.isMovable(input)).isTrue()
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `랜덤 값이 4 미만이면 false 를 반환한다`(input: Int) {
        assertThat(roundResult.isMovable(input)).isFalse()
    }
}
