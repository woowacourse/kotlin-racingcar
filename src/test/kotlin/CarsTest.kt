import generator.RandomGenerator
import model.Car
import model.Cars
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {

    val inputCars = listOf(Car("pobi"), Car("woni"), Car("gugu"))

    @Test
    fun `자동차 이름들 ','로 구분되어 생성되었는지 확인`() {
        val mappingCars = Cars.mappingCars("pobi,woni,gugu", RandomGenerator())
        assertThat(mappingCars.cars[0].name).isEqualTo(inputCars[0].name)
        assertThat(mappingCars.cars[1].name).isEqualTo(inputCars[1].name)
        assertThat(mappingCars.cars[2].name).isEqualTo(inputCars[2].name)
    }
}
