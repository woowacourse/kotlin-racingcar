package car

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CarsTest {

    @Test
    fun `차들을 이동한다`() {
        val cars = Cars(listOf(Car(0), Car(0), Car(0)))
        cars.moveAll()
        cars.cars.all { Position(1) == it.position } // todo data class여서 ==으로?
    }
}