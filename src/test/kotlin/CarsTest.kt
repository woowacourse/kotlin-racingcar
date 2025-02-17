import domain.cars.Cars
import domain.numbergenerator.NumberGenerator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.collections.ArrayDeque

class CarsTest {
    @Test
    fun `우승자를 확인할 수 있다 `() {
        val cars = getDummy()
        val expected = "디노"

        assertEquals(expected, cars.getWinners())
    }
}

fun getDummy(): Cars {
    val arguments = RacingCarConverter.toCarsArgument("포비,크론,디노")
    val cars = Cars(arguments)
    cars.lap(TestWinnerNumberGenerator())
    return cars
}

private class TestWinnerNumberGenerator : NumberGenerator {
    private val queue = ArrayDeque<Int>()

    init {
        queue.add(1)
        queue.add(2)
        queue.add(7)
    }

    override fun generate(): Int {
        return queue.removeFirstOrNull() ?: 0
    }
}
