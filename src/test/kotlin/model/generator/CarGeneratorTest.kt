package model.generator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarGeneratorTest {

    @Test
    fun generateCarsTest() {
        val names = listOf(NAME1, NAME2)

        val result = CarGenerator().generateCars(names)
        val carsName = result.map { car -> car.name }

        assertThat(names).isEqualTo(carsName)
    }

    companion object {
        const val NAME1 = "핑구"
        const val NAME2 = "우기"
    }
}
