package model.generator

import model.Car
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarGeneratorTest {
    @Test
    fun generateCarsTest() {
        val names = listOf("핑구", "우기")

        val result = CarGenerator().generateCars(names)
        val expectResult = listOf(Car("핑구"), Car("우기"))

        result.forEachIndexed { index, car -> assertThat(car).isEqualTo(expectResult[index]) }
    }
}
