package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class InitializationTest {

    private val initializer = Initialize()

    @Test
    fun initCarsTest() {
        val names = listOf(NAME1, NAME2)
        val input = names.joinToString(",")
        val cars = initializer.initCars(input)
        repeat(names.size) {
            assertTrue(cars[it].name == names[it])
        }
    }

    @Test
    fun initNumberOfTryTest() {
        assertThat(initializer.initNumberOfTry(NUMBER_OF_TRY_STRING)).isEqualTo(NUMBER_OF_TRY_INT)
    }

    companion object {
        const val NAME1 = "핑구"
        const val NAME2 = "우기"
        const val NUMBER_OF_TRY_STRING = "5"
        const val NUMBER_OF_TRY_INT = 5
    }
}
