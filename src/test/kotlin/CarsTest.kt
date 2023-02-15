import model.Cars
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {

    private val cars = Cars("pobi,dool,woni")
    @Test
    fun mappingCarsTest() {
        val carNames = listOf("pobi", "dool", "woni")
        repeat(cars.getCarSize()) {
            assertThat(cars.getCar(it).name).isEqualTo(carNames[it])
        }
    }

    @Test
    fun getCarSizeTest() {
        assertThat(cars.getCarSize()).isEqualTo(3)
    }
}
