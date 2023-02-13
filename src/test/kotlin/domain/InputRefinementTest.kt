package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InputRefinementTest {

    private val initializer = InputRefinement()

    @Test
    fun initCarsTest() {
        val names = listOf(NAME1, NAME2)
        val input = "$NAME1,$NAME2"
        val cars = initializer.initCars(input)

        val carsName = cars.map { car -> car.name }
        assertThat(names).isEqualTo(carsName)
    }

    @Test
    fun initNumberOfTryTest() {
        val input = initializer.initNumberOfTry(NUMBER_OF_TRY_STRING)

        assertThat(input).isEqualTo(NUMBER_OF_TRY_INT)
    }

    companion object {
        const val NAME1 = "핑구"
        const val NAME2 = "우기"
        const val NUMBER_OF_TRY_STRING = "5"
        const val NUMBER_OF_TRY_INT = 5
    }
}
