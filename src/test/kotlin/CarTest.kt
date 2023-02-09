import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.model.Car

class CarTest {

    lateinit var car: Car

    @BeforeEach
    fun beforeEach() {
        car = Car("soodal")
    }

    @Test
    fun testCarMovement() {
        val moveCount = 5

        repeat(moveCount) {
            car.move()
        }

        assertEquals("-".repeat(moveCount), car.getPositionAsDash())
    }
}