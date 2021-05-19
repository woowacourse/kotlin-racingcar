package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class CarsTest {

    @Test
    internal fun `create cars`() {
        //given
        val carGroup = listOf(Car("Benz"), Car("KIA"))

        //when
        val result = Cars(carGroup)

        //then
        assertThat(result).isNotNull
    }

    @DisplayName("모든 자동차를 전진 or 정지 시킨다")
    @Test
    internal fun moveAll() {
        //given
        val carGroup = listOf(Car("Benz"), Car("KIA"))
        val cars = Cars(carGroup)

        //when
        val movedCars = cars.moveAll()

        //then
        assertAll(
            { assertThat(movedCars.cars).hasSize(2) },
            { assertThat(movedCars.cars[0].position).isBetween(0, 1) },
            { assertThat(movedCars.cars[1].position).isBetween(0, 1) }
        )
    }

    @DisplayName("자동차들 중 가장 먼 위치를 찾는다")
    @Test
    internal fun `findMaxPosition`() {
        //given
        val cars = Cars(listOf(Car("BENZ", 3), Car("KIA", 1)))

        //when
        val maxPosition = cars.findMaxPosition()

        //then
        assertThat(maxPosition).isEqualTo(3)
    }

    @DisplayName("자동차들 중에서 주어진 값과 같은 위치에 있는 자동차들을 찾는다")
    @Test
    internal fun `findCarsBySamePosition`() {
        //given
        val cars = Cars(listOf(Car("BENZ", 3), Car("KIA", 1),
        Car("ROKI", 3)))

        //when
        val findCars = cars.findCarsBySamePosition(3)

        //then
        assertAll(
            { assertThat(findCars).hasSize(2)},
            { assertThat(findCars[0].position).isEqualTo(3)},
            { assertThat(findCars[1].position).isEqualTo(3)}
        )
    }
}
