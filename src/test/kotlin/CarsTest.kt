import domain.cars.Cars
import domain.numbergenerator.NumberGenerator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarsTest {
    @Test
    fun `우승자가 한 명인 경우를 확인할 수 있다`() {
        val cars = Cars("포비,크론,디노")
        cars.moveAll(TestNumberGenerator(mutableListOf(1, 2, 5)))
        val expected = "디노"
        assertEquals(expected, cars.getWinners())
    }

    @Test
    fun `우승자가 여러 명인 경우를 확인할 수 있다`() {
        val cars = Cars("포비,크론,디노")
        cars.moveAll(TestNumberGenerator(mutableListOf(1, 4, 5)))
        val expected = "크론, 디노"
        assertEquals(expected, cars.getWinners())
    }

    private class TestNumberGenerator(private val numbers: MutableList<Int>) : NumberGenerator {
        override fun generate(): Int {
            return numbers.removeFirst()
        }
    }
}
