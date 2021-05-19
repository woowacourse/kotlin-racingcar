package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class CarsTest {

    @Test
    internal fun `create cars`() {
        //given
        val carGroup = listOf(Car(), Car())

        //when
        val cars = Cars(carGroup)

        //then
        assertThat(cars).isNotNull
    }

    @DisplayName("모든 자동차를 전진 or 정지 시킨다")
    @Test
    internal fun moveAll() {
        //given
        val carGroup = listOf(Car(), Car())
        val cars = Cars(carGroup)

        //when
        cars.moveAll()

        //then
        assertAll(
            { assertThat(cars.cars).hasSize(2) },
            { assertThat(cars.cars[0].position).isBetween(0, 1) },
            { assertThat(cars.cars[1].position).isBetween(0, 1) }
        )
    }
}
