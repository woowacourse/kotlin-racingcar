import model.Car
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {

    @Test
    fun getInfoTest() {
        assertThat(Car("dool", 0).getInfo()).isEqualTo(Pair("dool", 0))
        assertThrows<IllegalArgumentException> {
            assertThat(Car("dooly", 0).getInfo()).isEqualTo(Pair("dooly", 0))
        }
    }

    @Test
    fun moveTest() {
        val car = Car("dool", 0)
        car.move(3)
        assertThat(car.getInfo().second).isEqualTo(0)
        car.move(4)
        assertThat(car.getInfo().second).isEqualTo(1)
    }
}
