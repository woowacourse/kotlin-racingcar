import domain.cars.Cars
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarsTest {
    @Test
    fun `우승자를 확인할 수 있다 `() {
        val cars = getDummy()
        val expected = "포비, 크론, 디노"

        assertEquals(expected, cars.getWinners())
    }
}

fun getDummy(): Cars {
    val cars = Cars("포비,크론,디노")
    cars.lap(TestMoveNumberGenerator())
    return cars
}
