package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RacecourseTest {
    @ValueSource(ints = [0, 3])
    @ParameterizedTest
    fun `0에서 3이면 전진하지 않는다`(number: Int) {
        val race = Racecourse(listOf(Car("name")), 1)
        assertThat(race.isMovable(number)).isFalse()
    }

    @ValueSource(ints = [4, 9])
    @ParameterizedTest
    fun `4에서 9이면 전진한다`(number: Int) {
        val race = Racecourse(listOf(Car("name")), 1)
        assertThat(race.isMovable(number)).isTrue()
    }

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
