package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RacingCarsTest {
    private lateinit var carHandler: RacingCars
    private lateinit var cars: List<Car>

    @BeforeEach
    fun setup() {
        cars = listOf(Car("pobi"), Car("lee"), Car("jason"))
        carHandler = RacingCars(cars)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `전진 조건이 아닐 때 전진을 안했는지`(input: Int) {
        carHandler.proceed { input }

        assertThat(cars).allMatch { car -> car.position == "" }
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `전진 조건일 때 전진 했는지`(input: Int) {
        carHandler.proceed { input }

        assertThat(cars).allMatch { car -> car.position == "-" }
    }
}
