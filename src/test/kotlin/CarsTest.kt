import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {

    val cars = Cars("pobi,dool,woni")
    @Test
    fun mappingCarsTest() {
        val carNames = listOf("pobi", "dool", "woni")
        for (i in 0 until cars.getCarSize()) {
            assertThat(cars.getCar(i).getInfo().first).isEqualTo(carNames[i])
        }
    }

    @Test
    fun getCarSizeTest() {
        assertThat(cars.getCarSize()).isEqualTo(3)
    }

    @Test
    fun findWinners() {
        cars.getCar(0).move(4)
        val winners = listOf("pobi")
        assertThat(cars.findWinners()).isEqualTo(winners)
    }
}
