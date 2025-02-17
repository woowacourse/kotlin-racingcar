package test

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.domain.Racecourse
import racingcar.domain.RoundManager

class RacecourseTest {
    @Test
    fun `자동차 경주 게임의 우승자는 가장 멀리 간 사람이다`() {
        val cars: List<Car> = listOf(Car("A"), Car("B"), Car("C"))
        cars.first().move(9)
        val racecourse = Racecourse(cars, RoundManager(0))
        Assertions.assertThat(racecourse.winners).isEqualTo(listOf(cars.first()))
    }
}
