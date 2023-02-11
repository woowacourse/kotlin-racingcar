import model.Car
import model.Cars
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {

    val cars = listOf(Car("pobi"), Car("woni"), Car("gugu"))

    @Test
    fun `자동차 ','로 구분되었는지 확인`() {
        val mappingCars = Cars.mappingCars("pobi,woni,gugu")
        assertThat(mappingCars.cars[0].name).isEqualTo(cars[0].name)
        assertThat(mappingCars.cars[1].name).isEqualTo(cars[1].name)
        assertThat(mappingCars.cars[2].name).isEqualTo(cars[2].name)
    }
}
