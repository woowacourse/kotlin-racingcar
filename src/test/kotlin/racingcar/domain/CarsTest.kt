package racingcar.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun duplicatedNames() {
        val names = listOf("pobi", "jason", "pobi")

        assertThatIllegalArgumentException().isThrownBy { Cars.from(names) }
    }

    @Test
    fun emptyNames() {
        val names = "".split(",")

        assertThatIllegalArgumentException().isThrownBy { Cars.from(names) }
    }

    @Test
    fun moveCars() {
        val cars = Cars(listOf(Car("pobi"), Car("jason")))

        assertThatCode { cars.move() }
            .doesNotThrowAnyException()
    }

    @Test
    fun findWinners() {
        val cars = Cars(
            listOf(
                Car("pobi", 2),
                Car("jason", 2),
                Car("paran", 1)
            )
        )

        assertThat(cars.findWinners())
            .contains(Car("pobi", 2), Car("jason", 2))
    }
}
