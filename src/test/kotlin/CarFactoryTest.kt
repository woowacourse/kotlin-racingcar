import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class CarFactoryTest {
    @Test
    fun `자동차 익명 생성 테스트`() {
        val carFactory = CarFactory()
        val carsName = listOf("", "  ", "    ")
        val actual = listOf(Car("익명1"), Car("익명2"), Car("익명3"))
        assertThat(actual).isEqualTo(carFactory.createCar(carsName))
    }

    @Test
    fun `자동차 익명 실패 테스트`() {
        val carFactory = CarFactory()
        val carsName = listOf("", "  ", "    ")
        val actual = listOf(Car("익명1"), Car("익명8"), Car("익명3"))
        assertFalse(actual == carFactory.createCar(carsName))
    }
}
