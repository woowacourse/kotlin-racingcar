import model.Cars
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {

    private val cars = Cars("pobi,dool,woni")
    @Test
    fun mappingCarsTest() {
        val carNames = listOf("pobi", "dool", "woni")
        for (i in 0 until cars.getCarSize()) {
            assertThat(cars.getCarInfo(i).first).isEqualTo(carNames[i])
        }
    }

    @Test
    fun getCarSizeTest() {
        assertThat(cars.getCarSize()).isEqualTo(3)
    }
}
