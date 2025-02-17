package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

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
}
