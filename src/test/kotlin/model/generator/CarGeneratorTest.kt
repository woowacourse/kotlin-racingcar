package model.generator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarGeneratorTest {

    @Test
    fun generateCarsTest() {
        val names = listOf("핑구", "우기")

        val result = CarGenerator().generateCars(names)
        val carsName = result.map { car -> car.name }

        assertThat(names).isEqualTo(carsName)
    }
}
