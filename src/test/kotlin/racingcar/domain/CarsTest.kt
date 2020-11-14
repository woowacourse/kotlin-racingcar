package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarsTest {

    @Test
    fun getSize() {
        val cars = arrayListOf(Car("a"), Car("b"))

        assertThat(Cars(cars).size).isEqualTo(cars.size)
    }

    @Test
    fun getWinner() {
        val cars = arrayListOf(Car("a"), Car("b", Position(1)), Car("c", Position(1)))

        assertThat(Cars(cars).winner.size).isEqualTo(2)
    }

    @Test
    fun go() {
        val name = "a"
        val name1 = "b"

        val roundResult = Cars(arrayListOf(Car(name), Car(name1))).go()

        assertThat(roundResult[0].name).isEqualTo(name)
        assertThat(roundResult[1].name).isEqualTo(name1)
    }
}