import model.Car
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {

    @Test
    fun getInfoTest() {
        val car = Car("dool")
        assertThat(car.getInfo().name).isEqualTo("dool")
        assertThat(car.getInfo().position).isEqualTo(0)
    }

    @Test
    fun getInfoExceptionTest() {
        assertThrows<IllegalArgumentException> {
            Car("dooly", 0)
        }
    }

    @Test
    fun moveTest() {
        val car = Car("dool")
        car.move(3)
        assertThat(car.getInfo().position).isEqualTo(0)
    }

    @Test
    fun dontMoveTest() {
        val car = Car("dool")
        car.move(4)
        assertThat(car.getInfo().position).isEqualTo(1)
    }
}
