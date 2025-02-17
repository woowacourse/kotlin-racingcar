package test

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.domain.Racecourse

class RacecourseTest {
    @Test
    fun `자동차 경주 게임의 우승자는 가장 멀리 간 사람이다`() {
        val cars: List<Car> = Car.createCars("a,b,c")
        cars.first().move(9)
        val racecourse = Racecourse(cars, 0)
        Assertions.assertThat(racecourse.winners).isEqualTo(listOf(cars.first()))
    }
}
