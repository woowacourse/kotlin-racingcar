package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacecourseTest {
    @Test
    fun `자동차 경주 게임을 완료한 후 가장 큰 distance를 가진 객체가 우승한다`() {
        val cars: List<Car> =
            listOf(
                Car(name = "a", initialDistance = 5),
                Car(name = "b", initialDistance = 5),
                Car(name = "c", initialDistance = 0),
            )
        val racecourse = Racecourse(cars, 0)
        val expectedWinners = listOf(Car(name = "a", initialDistance = 5), Car(name = "b", initialDistance = 5))
        assertThat(
            racecourse.winners.joinToString { car: Car ->
                car.name
            },
        ).isEqualTo(expectedWinners.joinToString { car: Car -> car.name })
    }
}
