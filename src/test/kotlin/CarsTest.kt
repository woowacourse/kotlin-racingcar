import domain.cars.Cars
import domain.numbergenerator.TestNumberGenerator
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CarsTest {
    @Test
    fun `우승자를 확인할 수 있다 `() {
        val cars = Cars("포비,크론,디노")
        cars.moveAll(TestNumberGenerator(mutableListOf(1, 2, 5)))
        val expected = "디노"
        Assertions.assertEquals(expected, cars.getWinners())
    }
}
