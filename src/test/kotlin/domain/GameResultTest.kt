package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameResultTest {
    private val redCar = Car("red", 1)
    private val blueCar = Car("blue", 2)
    private val greenCar = Car("green", 3)
    private val yellowCar = Car("yello", 3)
    private val cars: List<Car> = listOf(redCar, blueCar, greenCar, yellowCar)

    private val gameResult = GameResult(cars)
    private val correctResult: List<Car> = listOf(greenCar, yellowCar)

    @Test
    fun `현재 위치가 가장 큰 자동차들을 우승 자동차 리스트로 반환한다`() {
        val winners: List<Car> = gameResult.getFinalResult()

        assertThat(winners).isEqualTo(correctResult)
    }
}
